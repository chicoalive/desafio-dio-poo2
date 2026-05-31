package model.entities;

import java.util.*;

// Dev representa um desenvolvedor inscrito em um BootCamp
// Possui dois conjuntos de conteúdos: os que ainda precisa concluir e os que já concluiu
public class Dev {
    private String name;

    // LinkedHashSet: mantém a ordem de inserção — o dev consome os conteúdos na sequência cadastrada
    // e garante que o mesmo conteúdo não apareça duas vezes na lista
    private Set<Content> subscribedContents = new LinkedHashSet<>();
    private Set<Content> completedContents = new LinkedHashSet<>();

    // Construtor: todo Dev precisa de um nome para ser identificado (usado no equals/hashCode)
    public Dev(String name) {
        this.name = name;
    }

    // Getters: expõem os atributos de forma controlada
    public String getName() {
        return name;
    }

    public Set<Content> getSubscribedContents() {
        return subscribedContents;
    }

    public Set<Content> getCompletedContents() {
        return completedContents;
    }

    // Setter: permite renomear o dev após a criação
    public void setName(String name) {
        this.name = name;
    }

    // Inscreve o dev em um BootCamp:
    // 1. Copia todos os conteúdos do bootcamp para a lista de inscritos do dev (addAll)
    // 2. Adiciona o próprio dev na lista de inscritos do bootcamp
    // Assim ambos os lados da relação ficam atualizados
    public void signBootcamp(BootCamp bootcamp) {
        this.subscribedContents.addAll(bootcamp.getContents());
        bootcamp.getDevSubscribers().add(this);
    }

    // Avança o dev em um conteúdo:
    // Stream.findFirst() pega o primeiro item da fila (respeitando a ordem do LinkedHashSet)
    // Optional é usado para evitar NullPointerException caso a lista esteja vazia
    // Se houver conteúdo: move da lista de inscritos para a de concluídos
    // Se não houver: exibe mensagem de erro no System.err (canal de erros, separado do System.out)
    public void progress() {
        Optional<Content> content = this.subscribedContents.stream().findFirst();
        if (content.isPresent()) {
            this.completedContents.add(content.get());
            this.subscribedContents.remove(content.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    // Calcula o XP total somando o XP de cada conteúdo concluído
    // Usa Iterator explicitamente — forma clássica de percorrer coleções em Java
    // Cada conteúdo chama seu próprio calculateXp() — polimorfismo: Course e Mentorship calculam de formas diferentes
    public double calculateTotalXp(){
        Iterator<Content> iterator = this.completedContents.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            Content content = iterator.next();
            sum += content.calculateXp();
        }
        return sum;
    }

    // equals: dois Devs são iguais se tiverem o mesmo nome
    // Necessário para que o HashSet do BootCamp não permita o mesmo dev inscrito duas vezes
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dev dev)) return false;
        return Objects.equals(name, dev.name);
    }

    // hashCode: gerado a partir do nome — deve ser consistente com o equals
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

package model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

// BootCamp representa um programa de aprendizado com período definido, conteúdos e devs inscritos
public class BootCamp {
    private String name;
    private String description;

    // Data de início é o momento da criação do objeto; data de término é calculada automaticamente
    // final: não podem ser alteradas após a inicialização — o prazo é fixo
    // plusDays(45): adiciona 45 dias corridos à data de início para definir o encerramento
    private final LocalDate startDate = LocalDate.now();
    private final LocalDate endDate = startDate.plusDays(45);

    // HashSet: não permite devs duplicados e tem busca/inserção O(1) — ordem não importa aqui
    private Set<Dev> devSubscribers = new HashSet<>();

    // LinkedHashSet: não permite conteúdos duplicados E mantém a ordem de inserção
    // A ordem importa pois o dev consome os conteúdos na sequência em que foram adicionados
    private Set<Content> contents = new LinkedHashSet<>();

    // Getters: expõem os atributos de forma controlada (encapsulamento)
    // startDate e endDate não têm setters pois são final — imutáveis após a criação
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Set<Dev> getDevSubscribers() {
        return devSubscribers;
    }

    public Set<Content> getContents() {
        return contents;
    }

    // Setters: permitem alterar name e description após a criação do objeto
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // HashSet.add() já ignora duplicatas automaticamente (usa equals/hashCode do Dev)
    public void addDev(Dev dev) {
        devSubscribers.add(dev);
    }

    public void removeDev(Dev dev) {
        devSubscribers.remove(dev);
    }

    // LinkedHashSet.add() ignora duplicatas e preserva a ordem de inserção dos conteúdos
    public void addContent(Content content) {
        contents.add(content);
    }

    public void removeContent(Content content) {
        contents.remove(content);
    }

    // equals: dois BootCamps são considerados iguais se tiverem o mesmo nome e descrição
    // Necessário para que o HashSet/LinkedHashSet consiga detectar duplicatas corretamente
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BootCamp bootCamp)) return false;
        return Objects.equals(name, bootCamp.name) && Objects.equals(description, bootCamp.description);
    }

    // hashCode: gerado a partir dos mesmos campos do equals — regra obrigatória em Java:
    // objetos iguais pelo equals DEVEM ter o mesmo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}

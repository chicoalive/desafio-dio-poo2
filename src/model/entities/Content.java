package model.entities;

// Classe abstrata: define o contrato comum para todos os tipos de conteúdo (Curso, Mentoria, etc.)
// Não pode ser instanciada diretamente — serve como base para herança
public abstract class Content {
    // Constante de XP base compartilhada por todas as subclasses
    // protected: visível nas subclasses; static: pertence à classe, não ao objeto; final: imutável
    protected static final double XP = 10.0;

    // Atributos encapsulados com private — acesso controlado via getters/setters
    private String title;
    private String description;

    // Construtor que força toda subclasse a informar título e descrição ao ser criada
    public Content(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getter: retorna o título do conteúdo
    public String getTitle() {
        return title;
    }

    // Setter: permite alterar o título após a criação do objeto
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter: retorna a descrição do conteúdo
    public String getDescription() {
        return description;
    }

    // Setter: permite alterar a descrição após a criação do objeto
    public void setDescription(String description) {
        this.description = description;
    }

    // Método abstrato: cada subclasse DEVE implementar sua própria regra de cálculo de XP
    // Polimorfismo em ação — o comportamento muda conforme o tipo concreto (Course, Mentorship...)
   public abstract double calculateXp();

    // toString sobrescrito para exibir os dados do conteúdo de forma legível
    // As subclasses chamam super.toString() para reaproveitar este trecho
    @Override
    public String toString() {
        return "Titúlo: " + title + "\n" + "Descrição: " + description;
    }
}

package model.entities;

import java.time.LocalDate;

// Mentorship estende Content: representa uma mentoria ao vivo, com data específica
// Diferente de Course, o XP é fixo (base + bônus), pois não há carga horária
public class Mentorship extends Content {

    // Data em que a mentoria ocorre — usada para exibição e controle
    private LocalDate date;

    // Construtor: repassa título e descrição para Content e inicializa a data da mentoria
    public Mentorship(String title, String description, LocalDate date) {
        super(title, description);
        this.date = date;
    }

    // Getter: retorna a data da mentoria
    public LocalDate getDate() {
        return date;
    }

    // Implementação do método abstrato: mentoria vale XP base + 20 de bônus por ser ao vivo
    @Override
    public double calculateXp() {
        return XP + 20.0;
    }

    // Reutiliza o toString da classe pai e acrescenta a data da mentoria
    @Override
    public String toString() {
        return super.toString() + String.format("\nData: %s", date);
    }
}

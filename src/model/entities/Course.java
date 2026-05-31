package model.entities;

// Course estende Content: herda title, description e XP, e implementa a regra de XP por carga horária
public class Course extends Content {

    // Carga horária do curso — usada para calcular o XP proporcional ao tempo investido
    private double workLoad;

    // Construtor: repassa título e descrição para a classe pai via super() e inicializa a carga horária
    public Course(String title, String description, double workLoad) {
        super(title, description);
        this.workLoad = workLoad;
    }

    // Getter: retorna a carga horária do curso
    public double getWorkLoad() {
        return workLoad;
    }

    // Implementação do método abstrato: XP é proporcional à carga horária (ex: 10h * 10.0 = 100 XP)
    @Override
    public double calculateXp() {
        return workLoad * XP;
    }

    // Reutiliza o toString da classe pai (título + descrição) e acrescenta a carga horária formatada
    @Override
    public String toString() {
        return super.toString() + String.format("\nCarga horária: %.2f", workLoad);
    }
}


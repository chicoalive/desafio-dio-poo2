package application;

import model.entities.BootCamp;
import model.entities.Course;
import model.entities.Dev;
import model.entities.Mentorship;

import java.time.LocalDate;
import java.util.Scanner;

// Ponto de entrada da aplicação
// Aqui são criados os objetos (BootCamp, Course, Mentorship, Dev) e simulado o fluxo completo
public class Program {
    public static void main(String[] args) {
        // ==========================================
        // 1. PARTE FIXA (Igual ao código da instrutora)
        // O sistema já inicia com os conteúdos criados
        // ==========================================
        Course course1 = new Course("Curso Java", "Descrição curso java", 8);

        Mentorship mentorship = new Mentorship("Mentoria de Java", "Descrição mentoria java", LocalDate.now());

        BootCamp bootcamp = new BootCamp();
        bootcamp.setName("Bootcamp Java Developer");
        bootcamp.setDescription("Descrição Bootcamp Java Developer");
        bootcamp.addContent(course1);
        bootcamp.addContent(mentorship);

        // ==========================================
        // 2. PARTE DINÂMICA (A sua ideia com Scanner)
        // O usuário interage com o sistema
        // ==========================================
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao " + bootcamp.getName() + "!");
        System.out.print("Para começar, digite o seu nome: ");
        String typedName = scanner.nextLine().trim();

        // Criamos o Dev com o nome que o usuário digitou no terminal
        Dev loggedDev = new Dev(typedName);

        int option = -1;

        // Menu interativo: continua rodando até o usuário escolher a opção 0 (sair)
        while (option != 0) {
            System.out.println("\n--- MENU DO ALUNO ---");
            System.out.println("1 - Fazer matrícula no Bootcamp");
            System.out.println("2 - Estudar próximo conteúdo (Progredir)");
            System.out.println("3 - Ver meu status (Inscritos, Concluídos e XP)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    loggedDev.signBootcamp(bootcamp);
                    System.out.println("Matrícula realizada com sucesso!");
                    break;
                case 2:
                    loggedDev.progress();
                    System.out.println("Ação de progresso executada!");
                    break;
                case 3:
                    System.out.println("\n--- STATUS DE " + loggedDev.getName().toUpperCase() + " ---");
                    System.out.println("Conteúdos Inscritos: " + loggedDev.getSubscribedContents());
                    System.out.println("Conteúdos Concluídos: " + loggedDev.getCompletedContents());
                    System.out.println("Total de XP: " + loggedDev.calculateTotalXp());
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}

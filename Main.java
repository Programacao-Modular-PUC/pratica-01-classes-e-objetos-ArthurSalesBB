import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        
        Pessoa[] pessoas = new Pessoa[10];
        int totalCadastrados = 0;

        System.out.println("=== CADASTRO DE PESSOAS (Máx: 10) ===");

        for (int i = 0; i < 10; i++) {
            System.out.println("\nDigitando dados da pessoa " + (i + 1) + ":");
            
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();
            
            System.out.print("Sobrenome: ");
            String sobrenome = scanner.nextLine().trim();

            if (i > 0) {
                String nomeCompletoAtual = nome + " " + sobrenome;
                String nomeCompletoAnterior = pessoas[i - 1].getNome() + " " + pessoas[i - 1].getSobrenome();
                
                if (nomeCompletoAtual.equalsIgnoreCase(nomeCompletoAnterior)) {
                    System.out.println("Critério de parada atingido: Nome idêntico ao anterior cadastrado.");
                    break;
                }
            }

            System.out.print("Data de Nascimento (dd/mm/aaaa): ");
            String dataStr = scanner.nextLine();

            String[] partesData = dataStr.split("/");
            int dia = Integer.parseInt(partesData[0]);
            int mes = Integer.parseInt(partesData[1]);
            int ano = Integer.parseInt(partesData[2]);
            Data dataNascimento = new Data(dia, mes, ano);

            System.out.print("Altura (ex: 1.75): ");
            double altura = scanner.nextDouble();

            System.out.print("Peso (em kg, ex: 70.5): ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); 

            pessoas[i] = new Pessoa(nome, sobrenome, altura, peso, dataNascimento);
            totalCadastrados++;
        }

        System.out.println("\n====================================");
        System.out.println("       RELATÓRIO DE CADASTROS       ");
        System.out.println("====================================");

        for (int i = 0; i < totalCadastrados; i++) {
            Pessoa p = pessoas[i];

            String nomeReferencia = p.getSobrenome() + ", " + p.getNome().toUpperCase();

            System.out.println("Cadastro " + (i + 1) + ":");
            System.out.println("Nome completo: " + p.getNome() + " " + p.getSobrenome());
            System.out.println("Nome de referência: " + nomeReferencia);
            System.out.println("Idade: " + p.getIdade());
            System.out.printf("Peso: %.1f\n", p.getPeso());
            System.out.printf("Altura: %.2f\n", p.getAltura());
            System.out.printf("IMC: %.2f\n", p.calculaIMC());
            System.out.println("Classificação: " + p.informaObesidade());
            System.out.println("------------------------------------");
        }

        scanner.close();
    }
}
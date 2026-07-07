import java.util.Calendar;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;
    private Data dataNascimento; 

    public Pessoa(String nome, String sobrenome, double altura, double peso, Data dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.altura = altura;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
        this.idade = calculaIdade(dataNascimento);
    }

    public int calculaIdade(Data dataNasc) {
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH) + 1; 
        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);

        int idadeCalculada = anoAtual - dataNasc.getAno();

        if (mesAtual < dataNasc.getMes() || (mesAtual == dataNasc.getMes() && diaAtual < dataNasc.getDia())) {
            idadeCalculada--;
        }

        return idadeCalculada;
    }

    public double calculaIMC() {
        this.imc = this.peso / Math.pow(this.altura, 2);
        return this.imc;
    }

    public String informaObesidade() {
        if (this.imc < 18.5) return "Abaixo do peso";
        else if (this.imc < 25.0) return "Peso normal (Saudável)";
        else if (this.imc < 30.0) return "Sobrepeso";
        else if (this.imc < 35.0) return "Obesidade Grau I";
        else if (this.imc < 40.0) return "Obesidade Grau II (Severa)";
        else return "Obesidade Grau III (Mórbida)";
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public int getIdade() { return idade; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getImc() { return imc; }

    public Data getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(Data dataNascimento) { this.dataNascimento = dataNascimento; }
}
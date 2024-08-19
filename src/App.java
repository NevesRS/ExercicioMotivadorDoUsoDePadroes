public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, 6, 45 );
        Carro utilitario = new Carro("Utilitário", TipoCombustivel.DIESEL, 6, 70 );
        Carro suv = new Carro("SUV", TipoCombustivel.FLEX, 8, 55);
        Carro suvFlex = new Carro("SUVFlex", TipoCombustivel.FLEX, 8, 65);
        Carro econo = new Carro("Econo", TipoCombustivel.FLEX, 20, 55);

        System.out.println("Tipo de veiculos:");
        System.out.println(basico);
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);

        System.out.println("Tipo de veiculos:");
        System.out.println(esportivo);
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro esportivo com gasolina");
        esportivo.abastece(TipoCombustivel.GASOLINA, 45);
        System.out.println(esportivo);
        System.out.println("\nViajando com o carro esportivo");
        esportivo.viaja(120);
        esportivo.viaja(150);
        System.out.println(esportivo);

        System.out.println("Tipo de veiculos:");
        System.out.println(utilitario);
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro utilitário com diesel");
        utilitario.abastece(TipoCombustivel.DIESEL, 70);
        System.out.println(utilitario);
        System.out.println("\nViajando com o carro utilitário");
        utilitario.viaja(300);
        utilitario.viaja(120);
        System.out.println(utilitario);

        System.out.println("Tipo de veiculos:");
        System.out.println(suv);
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro SUV com alcool");
        suv.abastece(TipoCombustivel.FLEX, 55);
        System.out.println(suv);
        System.out.println("\nViajando com o carro SUV");
        suv.viaja(240);
        suv.viaja(200);
        System.out.println(suv);

        System.out.println("Tipo de veiculos:");
        System.out.println(suvFlex);
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro SUVFlex com gasolina");
        suvFlex.abastece(TipoCombustivel.GASOLINA, 65);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro SUVFlex");
        suvFlex.viaja(320);
        suvFlex.viaja(200);
        System.out.println(suvFlex);

        System.out.println("Tipo de veiculos:");
        System.out.println(suvFlex);
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro SUVFlex com alcool");
        suvFlex.abastece(TipoCombustivel.ALCOOL, 65);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro SUVFlex");
        //Precisa de 520 Km rodados para esvaziar o gás
        suvFlex.viaja(310);
        suvFlex.viaja(210);
        System.out.println(suvFlex);

        System.out.println("Tipo de veiculos:");
        System.out.println(econo);
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro econo com gasolina");
        suvFlex.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(econo);
        System.out.println("\nViajando com o carro econo");
        econo.viaja(1300);
        econo.abastece(TipoCombustivel.GASOLINA, 65);
        econo.viaja(1300);
        econo.abastece(TipoCombustivel.GASOLINA, 65);
        econo.viaja(1300);
        econo.abastece(TipoCombustivel.GASOLINA, 65);
        econo.viaja(1100);
        econo.abastece(TipoCombustivel.GASOLINA, 65);
        //System.out.println(econo);

        //Jeito chatGPT
        /*
         * public class Carro {

private String modelo;
private Motor motor;
private TanqueCombustivel tanque;

public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque) {
this.modelo = modelo;
motor = new Motor(tipoCombustivel, consumoMotor);
tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
}

public String getModelo() {
return modelo;
}

public int getCombustivelDisponivel() {
return tanque.getCombustivelDisponivel();
}

// Retorna a quantidade efetivamente abastecida
public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
if (capacidadeLivre < quantidade) {
tanque.abastece(tipoCombustivel, capacidadeLivre);
return capacidadeLivre;
} else {
tanque.abastece(tipoCombustivel, quantidade);
return quantidade;
}
}

// Retorna a distancia que consegue viajar com o combustivel remanescente
public int verificaSePodeViajar(int distancia) {
int combustivelNecessario;
if ("Econo".equals(modelo)) {
combustivelNecessario = calculaConsumoEcono(distancia);
} else {
combustivelNecessario = motor.combustivelNecessario(distancia);
}
if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
return distancia;
} else {
return tanque.getCombustivelDisponivel() * motor.getConsumo();
}
}

// Método específico para o consumo do Econo
private int calculaConsumoEcono(int distancia) {
// Ajusta o consumo do Econo baseado na quilometragem
int consumoInicial = 20;
int consumoFinal = 10;
int quilometragem = motor.getQuilometragem();
int consumoAtual = consumoInicial - (quilometragem / 5000);
consumoAtual = Math.max(consumoAtual, consumoFinal);
return distancia / consumoAtual;
}

// Retorna true se conseguiu viajar
public boolean viaja(int distancia) {
if (verificaSePodeViajar(distancia) >= distancia) {
motor.percorre(distancia);
tanque.gasta(motor.combustivelNecessario(distancia));
return true;
}
return false;
}

@Override
public String toString() {
return "Carro:\n Modelo=" + modelo + "\n Motor=" + motor + "\n Tanque=" + tanque;
}
}
         */
        
    }
}

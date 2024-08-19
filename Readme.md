# Enunciado do exercício

RESPOSTAS:

1) Instanciamos o objeto no APP e criamos a viagem
   
2) Instanciamos o objeto no APP, criamos a viagem e adicionamos o Diesel ao enum

3) Instanciamos o objeto no APP e criamos a viagem

4) Instanciamos o objeto no APP e criamos suas respectivas viagens, nas quais foi gasto primeiramente todo o tanque a
base de gasolina, e depois com álcool 
   
5) Instanciamos o objeto no APP e criamos a viagem;
   Criamos o dominuirConsumo => 20, 19, ... 10
   Criamos getKmRodados => Para verificar os 5000 km rodados para que seja ṕossível diminuir o consumoMotor
   Além de quando chegarmos aos 10 km no consumoMotor, ele se estabilizará através de um if
                           if(motor.getConsumo() >= 10){
                              if(kmRodados >= 5000){
                                 kmRodados = 0;
                                 motor.diminuirConsumo();
                              }
                           }
   Mudamos para public o motor => Para alterar o consumoMotor 

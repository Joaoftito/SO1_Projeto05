# Threads com Semáforos parte 2

## Projeto 1
- Simular em Java: 4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms. O corredor é escuro, tem 2 km e em 500 m, há uma única tocha. O cavaleiro que pegar a tocha, aumenta sua velocidade, somando mais 2 m por 50 ms ao valor que já fazia. Em 1,5 km, existe uma pedra brilhante. O cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m por 50 ms ao valor que já fazia (O cavaleiro que já detém a tocha não poderá pegar a pedra). Ao final dos 2 km, os cavaleiros se deparam com 4 portas e, um por vez pega uma porta aleatória (que não pode repetir) e entra nela. Apenas uma porta leva à saída. As outras 3 tem monstros que os devoram.

## Projeto 2
- Um aeroporto tem 2 pistas (norte e sul) e, em cada pista, apenas um avião pode fazer a decolagem. 
   - O procedimento de decolagem tem 4 fases (taxiar, decolagem e afastamento da área). A fase de manobra pode durar de 300 a 700 milissegundos A fase de taxiar, de 500 a 1000 milissegundos. A fase de decolagem, de 600 a 800 milissegundos.
   - A fase de afastamento, de 300 a 800 milissegundos. O aeroporto reúne, por ciclo, 12 aeronaves que podem decolar pela pista norte ou pela pista sul (decisão aleatória) mas, apenas 2 aviões podem circular pela área de decolagem ao mesmo tempo. Fazer uma aplicação em Java que resolva o problema.

## Projeto 3
- Numa prova de triatlo moderno, o circuito se dá da seguinte maneira:
  - 3Km de corrida onde os atletas correm entre 20 e 25 m/30 ms
  - 3 tiros ao alvo com pontuação de 0 a 10 
  - 5 km de ciclismo onde os atletas pedalam entre 30 e 40 m/40 ms
  - 25 atletas participam da prova e largam juntos, no entanto, apenas 5 armas de tiro estão a disposição. Cada atleta leva de 0,5 a 3s por tiro. Conforme os atletas finalizam o circuito de corrida, em ordem de chegada, pegam a arma para fazer os disparos. Uma vez encerrados os disparos, a arma é liberada para o próximo, e o atleta segue para pegar a bicicleta e continuar o circuito. Para determinar o ranking final dos atletas, considera-se a seguinte regra:
  - O primeiro que chegar recebe 250 pontos, o segundo recebe 240, o terceiro recebe 230,..., o último recebe 10.
  - Soma-se à pontuação de cada atleta, o total de pontos obtidos nos 3 tiros (somados)
  - Ordenar a pontuação e exibir o resultado final do maior pontuador para o menor.
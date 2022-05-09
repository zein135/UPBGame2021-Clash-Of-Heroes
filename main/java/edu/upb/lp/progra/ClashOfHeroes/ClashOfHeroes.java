package edu.upb.lp.progra.ClashOfHeroes;

public class ClashOfHeroes {
    private ClashOfHeroesUI ui;
    private Ficha[][] board=new Ficha[13][8];
    private static final int MAX_UNITS = 20;
    public ClashOfHeroes(ClashOfHeroesUI ui){
        this.ui=ui;
    }
    public int generateRandom(int min,int max){
        int random=(int)Math.floor(Math.random()*(max-min+1)+min);
        return random;
    }
    public void initGame(){
        for(int i=0;i<13;i++){
            for(int j=0;j<8;j++){
                board[i][j]=null;
            }
        }
        initEnemyBoard();
        initPlayerBoard();
    }
    public void initPlayerBoard(){
        int[] numUnits = new int[8];
        String[] colors = new String[]{"demon_red", "demon_purple", "demon_grey"};
        int idColor=0;
        int units=MAX_UNITS;
        int columna=0;
        while(units!=0){
            // 0 no coloca ficha, 1 coloco ficha
            int colocarFicha=generateRandom(0,1);
            if(colocarFicha==1 && numUnits[columna]<6){
                board[numUnits[columna]+7][columna]=new Ficha(colors[idColor]);
                idColor++;
                idColor%=3;
                numUnits[columna]++;
                units--;

            }
            columna++;
            columna%=8;
        }
//        for(int i=0;i<numUnits.length;i++){
//            for(int j=0;j<numUnits[i];j++){
//                ui.drawUnit(j+7,i,"demon_red");
//            }
//            for(int j=numUnits[i]+7;j<13;j++){
//                ui.drawUnit(j,i,"clash_of_heroes_fondo_desierto");
//            }
//        }
        draw();
    }
    public void draw(){
        // La matriz se llama board
        // int row = 0;
        for( int row = 0; row < 13 ; row++){
            for(int col=0;col<8;col++){
                if(board[row][col]==null){
                    //== null no tiene nada XD y si no tenemos nada que nos lo dibuje el fonfo
                    ui.drawUnit(row,col,"clash_of_heroes_fondo_desierto");
                }else{
                    ui.drawUnit(row,col,board[row][col].getName());
                }
            }
        }
    }
    public void initEnemyBoard() {
        //TODO
        //Enemigo
        int[] numUnits = new int[8];
        String[] colors = new String[]{"demon_grey", "demon_red", "demon_purple"};
        int units = MAX_UNITS;
        int col = 0;
        int idColor = 0;
        while (units != 0) {
            int colocarFicha = generateRandom(0, 1);
            if (colocarFicha == 1 && numUnits[col] < 6) {
                int row = 5 - numUnits[col];
                board[row][col] = new Ficha(colors[idColor]);
                idColor++;
                idColor %= 3;
                numUnits[col]++;
                units--;
            }
            col++;
            col %= 8;
        }
    }
}


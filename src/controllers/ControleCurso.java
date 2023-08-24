package controllers;

import entities.Curso;
import entities.Disciplina;
import entities.Professor;
import util.Input;
import util.MenusUtils;

import java.util.ArrayList;

public class ControleCurso implements ICadastro {

    private ArrayList<Curso> listaCursos = new ArrayList<>();
    public ArrayList<Curso> getListaCursos(){
        return listaCursos;
    }
    public static void menuControleCurso(){
        int op;

       /* do{
            op = Menus.selecionarOpcaoMenuCadastro("Curso");
            switch (op){
                case 1 ->
                    cadastrar();
                case 2 ->
                    pesquisar();
                case 3 ->
                    alterar();
                case 4 ->
                    remover();
                case 5 ->
                    listar();
            }
        }while(op != 0);*/
    }
    @Override
    public void cadastrar() {
        try{
            Curso curso = new Curso();
            setarDados(curso);
            MenusUtils.cadastroRealizadoComSucesso();
        }catch(Exception ex){
            MenusUtils.cadastroNaoRealizadoComSucesso();
        }
    }

    @Override
    public void alterar() {

    }

    protected void setarDados(Curso curso){
        System.out.print("Nome do curso: ");
        curso.setNome(Input.nextLine());
        System.out.print("Carga Horária: ");
        curso.setCargaHoraria(Input.nextInt());
        System.out.print("Qtd semestres: ");
        curso.setQtdSemestres(Input.nextInt());
        System.out.print("Coordenador: ");
        curso.setCoordenador(new Professor());// sla
        setarDisciplinasCurso(curso);


    }

    private static void setarDisciplinasCurso(Curso curso){
        boolean travaTela = true;
        do{
            System.out.print("Insira o nome da disciplina: ");
            String dadoBusca = Input.nextLine();
            Disciplina resultDisciplina = ControleDisciplina.pesquisaEquals(dadoBusca);
            if(resultDisciplina != null){
                System.out.println("Deseja realmente adicionar a disciplina " + resultDisciplina.getNome() + " ao curso de " + curso.getNome() + " ? (S/N)");
                String resp = Input.nextLine();

                if(MenusUtils.confirmacaoSim(resp)){
                    curso.getListaDisciplinas().add(resultDisciplina);
                    System.out.println("Deseja adicionar outra disciplina? (S/N)");
                    resp = Input.nextLine();
                    if (!MenusUtils.confirmacaoSim(resp)){
                        travaTela = false;
                    }
                }
            }else {
                System.out.println("\nDisciplina não encontrada !!\n");
            }
        }while (travaTela);

    }
    @Override
    public void pesquisar() {

    }

    @Override
    public void remover() {

    }

    @Override
    public void listar() {

    }
}

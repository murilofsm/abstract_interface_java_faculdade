package controllers;

import entities.Curso;
import entities.Disciplina;
import entities.Professor;
import util.Input;
import util.MenusUtils;

import java.util.ArrayList;

public class ControleCurso implements ICadastro {

    private static ArrayList<Curso> listaCursos = new ArrayList<>();
    public static ArrayList<Curso> getListaCursos(){
        return listaCursos;
    }

    public ControleCurso(){

    }

    public void menuControleCurso(){
        int op;
        do{
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
                    listar(listaCursos);
            }
        }while(op != 0);
    }
    @Override
    public void cadastrar() {
        if (ControleDisciplina.getListaDisciplinas().isEmpty()){
            System.out.println("\nCADASTRE ALGUMA DISCIPLINA ANTES !!!\n");
            return;
        }
        if (ControleProfessor.listaDeProfessores().isEmpty()){
            System.out.println("\nCADASTRE ALGUM PROFESSOR ANTES !!!\n");
            return;
        }


        try{
            Curso curso = new Curso();
            setarDados(curso);
            listaCursos.add(curso);
            MenusUtils.cadastroRealizadoComSucesso();
        }catch(Exception ex){
            MenusUtils.cadastroNaoRealizadoComSucesso();
        }
    }

    protected void setarDados(Curso curso){
        System.out.print("Nome do curso: ");
        curso.setNome(Input.nextLine());
        System.out.print("Carga Horária: ");
        curso.setCargaHoraria(Input.nextInt());
        System.out.print("Qtd semestres: ");
        curso.setQtdSemestres(Input.nextInt());


        System.out.println("Insira o nome/cpf do Coordenador: ");
        String coordPesquisa = Input.nextLine();

        Professor coord = (Professor) ControlePessoa.pesquisaEquals(coordPesquisa);

        if(coord != null){
            curso.setCoordenador(coord);
        }else{
            System.out.println("Parabéns, não lembra nem o nome do professor !!");
        }
        setarDisciplinasCurso(curso);


    }
    @Override
    public void alterar() {
        System.out.println("Insira o nome do Curso que deseja alterar: ");
        String nomeCurso = Input.nextLine();

        Curso cursoAlterar = pesquisaEquals(nomeCurso);

        if(cursoAlterar != null){
            setarDados(cursoAlterar);
            System.out.println("\nCurso alterado com sucesso !!\n");
        }else{
            System.out.println("\nCurso não foi encontrado !!\n");
        }

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
        pesquisarCurso();
    }
    private static void pesquisarCurso(){
        System.out.println("Insira o nome do Curso que deseja Buscar: ");
        String dadoBusca = Input.nextLine();
        ArrayList<Curso> resultBusca = pesquisaContains(dadoBusca);
        if(resultBusca.isEmpty()){
            listar(resultBusca);
        }
    }
    protected static ArrayList<Curso> pesquisaContains(String dadoBusca){
        ArrayList<Curso> result = new ArrayList<>();

        for (Curso listaCurso : getListaCursos()) {
            if(listaCurso.getNome().toLowerCase().contains(dadoBusca)){
                result.add(listaCurso);
            }
        }

        return result;
    }
    protected static Curso pesquisaEquals(String dadoBusca){
        for (Curso listaCurso : getListaCursos()) {
            if (listaCurso.getNome().toLowerCase().equals(dadoBusca)){
                return listaCurso;
            }
        }
        return null;
    }
    @Override
    public void remover() {
        realizarRemocao();
    }
    private static void realizarRemocao(){
        System.out.println("Insira o nome do curso que deseja remover: ");
        String dadoBusca = Input.nextLine();
        Curso cursoRemocao = pesquisaEquals(dadoBusca);
        if (cursoRemocao != null){
            try{
                System.out.println("Deseja realmente removar o curso: " + cursoRemocao.getInformacoes());
                String resp = Input.nextLine();
                if(MenusUtils.confirmacaoSim(resp)){
                    getListaCursos().remove(cursoRemocao);
                    MenusUtils.remocaoSucesso();
                }else {
                    MenusUtils.operacaoCanceladaComSucesso();
                }
            }catch (Exception ex){
                MenusUtils.erroRemocao();
            }
        }
    }
    @Override
    public void listar() {
        listar(getListaCursos());
    }
    private static void listar(ArrayList<Curso> listaCursos) {
        for (Curso listaCurso : listaCursos) {
            listaCurso.exibirInformacoes();
        }
    }
}

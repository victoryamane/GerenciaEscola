/**
 * Classe main
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

import controller.AlunoController;
import controller.CidadeController;
import view.MenuView;

public class Main {
	public static void main(String[] args) {
		AlunoController aluno = new AlunoController();
		CidadeController cidade = new CidadeController();
		
		new MenuView().iniciaGui();;
	}

}

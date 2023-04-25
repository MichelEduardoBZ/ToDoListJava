package View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import Controller.taskController;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static taskController taskController = new taskController();
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {

		System.out.println("--- To Do List ---");

		infinite: while (true) {
			System.out.println("------------------------------------");
			System.out.println("O que você deseja fazer?");
			System.out.println("Adicionar uma tarefa - 1");
			System.out.println("Remover uma tarefa - 2");
			System.out.println("Editar uma tarefa - 3");
			System.out.println("Mostrar todas as tarefas - 4");
			System.out.println("Sair - 5");
			System.out.print("Opção: ");
			Integer optionSelected = Integer.parseInt(sc.nextLine());

			switch (optionSelected) {
			case 1:
				addTask();
				break;
			case 2:
				removeList();
				break;
			case 3:
				editTask();
				break;
			case 4:
				showView();
				break;
			case 5:
				break infinite;
			}
		}
	}

	// Adiciona uma tarefa a lista
	public static void addTask() {
		System.out.println("--- Adicione sua Task ---");
		System.out.print("Informe o nome da task: ");
		String nameTask = sc.nextLine();

		System.out.print("Digite sua task: ");
		String descriptionTask = sc.nextLine();

		System.out.print("dd/MM/yyyy - Informe o prazo: ");
		try {
			LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
			taskController.addTask(nameTask, descriptionTask, date);
		} catch (DateTimeParseException e) {
			System.out.println("--- Atenção! ---\nData incorreta");
		}

	}

	// Remove uma tarefa da lista
	public static void removeList() {
		if (taskController.getListTask().isEmpty() == false) {
			System.out.println("-------------------------");
			System.out.print("Qual lista você deseja remover? ");
			int numTask = Integer.parseInt(sc.nextLine());

			try {
				taskController.removeList(numTask);
				System.out.println("Removido com sucesso!");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("--- Atenção! ---\nId inexistente");
			}
		} else {
			System.out.println("--- Atenção! ---\nNenhuma tarefa adicionada");
		}
	}

	// Mostra as tarefas
	public static void showView() {
		System.out.println("--- Lista ---");
		if (taskController.getListTask().isEmpty() == false) {
			System.out.println(taskController.showView());
		} else {
			System.out.println("--- Atenção! ---\nNenhuma tarefa adicionada");
		}
	}

	public static void editTask() {
		while (true) {
			
			if(taskController.getListTask().isEmpty()) {
				System.out.println("--- Atenção! ---\nNenhuma tarefa adicionada");
				break;
			}

			int numTask = 0;
			System.out.print("Qual task você deseja editar? ID: ");

			try {
				numTask = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("--- Atenção! --- \nNenhum número informado");
				break;
			}

			try {
				taskController.getListTask().get(numTask - 1);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("--- Atenção! --- \nEssa posição não existe na lista");
				break;
			}

			System.out.println("O que você deseja editar? Nome: 1 - Task: 2 - Data: 3");
			int editTaskNum = Integer.parseInt(sc.nextLine());

			if (editTaskNum == 1) {

				System.out.print("Digite o novo nome: ");
				String newNameTask = sc.nextLine();
				taskController.editList(numTask, editTaskNum, newNameTask);
				break;
			} else if (editTaskNum == 2) {
				System.out.print("Digite a nova tarefa: ");
				String newTask = sc.nextLine();
				taskController.editList(numTask, editTaskNum, newTask);
				break;
			} else if (editTaskNum == 3) {
				System.out.print("Digite a nova data: ");
				String date = sc.nextLine();
				try {
					taskController.editList(numTask, editTaskNum, date);
				} catch (DateTimeParseException e) {
					System.out.println("--- Atenção! ---\nData incorreta");
				}
				break;
			} else {
				System.out.println("--- Atenção! ---\nOpção inexistente");
				break;
			}
		}
	}
}

package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Tasks.task;

public class taskController {

	private task task;

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private List<task> listTask = new ArrayList<>();

	Integer i = 0;

	public task getTask() {
		return task;
	}

	public void setTask(task task) {
		this.task = task;
	}

	public List<task> getListTask() {
		return listTask;
	}

	public void setListTask(List<task> listTask) {
		this.listTask = listTask;
	}

	// Adiciona a task
	public void addTask(String nameTask, String descp, LocalDate date) {
		listTask.add(new task(nameTask, nameTask, date, i++));
	}

	// Remove uma task
	public void removeList(int id) {

		this.getListTask().remove(id - 1);

		int i = 0;
		for (task x : this.getListTask()) {
			i++;
			x.setId(i);
		}

	}

	// Edita uma task
	public void editList(int id, int editTaskNum, String task) {
		if (editTaskNum == 1) {
			this.getListTask().get(id - 1).setNameTask(task);
		} else if (editTaskNum == 2) {
			this.getListTask().get(id - 1).setTask(task);
		} else if (editTaskNum == 3) {
				LocalDate date = LocalDate.parse(task, fmt);
				this.getListTask().get(id - 1).setDate(date);
		}
	}

	// Mostra as tasks
	public String showView() {
		return this.getListTask().toString();
	}

}

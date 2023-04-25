package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Tasks.Task;

public class TaskController {

	private Task task;

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private List<Task> listTask = new ArrayList<>();

	Integer i = 0;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<Task> getListTask() {
		return listTask;
	}

	public void setListTask(List<Task> listTask) {
		this.listTask = listTask;
	}

	// Adiciona a task
	public void addTask(String nameTask, String descp, LocalDate date) {
		listTask.add(new Task(nameTask, nameTask, date, i++));
	}

	// Remove uma task
	public void removeList(int id) {

		this.getListTask().remove(id - 1);

		int i = 0;
		for (Task x : this.getListTask()) {
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

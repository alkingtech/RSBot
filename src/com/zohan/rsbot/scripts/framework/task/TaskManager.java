package com.zohan.rsbot.scripts.framework.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskManager implements Comparator<Task> {

	private List<Task> taskList = new ArrayList<Task>();

	@Override
	public int compare(Task arg0, Task arg1) {
		return arg1.priority() - arg0.priority();
	}

	public void add(Task... tasks) {
		for (Task t : tasks) {
			if (!taskList.contains(t)) {
				taskList.add(t);
			}
		}
		Collections.sort(taskList, this);
	}

	public void remove(Task... tasks) {
		for (Task t : tasks) {
			if (taskList.contains(t)) {
				taskList.remove(t);
			}
		}
	}

	public void removeAll() {
		taskList.clear();
	}

	public Task get() {
		for (Task t : taskList) {
			if (t.activate()){
				return t;
			}
		}
		return null;
	}

}

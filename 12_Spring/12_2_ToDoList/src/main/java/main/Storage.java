package main;

import response.ToDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage
{
    private static int currentId = 1;
    private static HashMap<Integer, ToDo> toDos = new HashMap<Integer, ToDo>();

    public static List<ToDo> getAllToDo()
    {
        ArrayList<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.addAll(toDos.values());
        return toDoList;
    }

    public static int addToDo(ToDo toDo)
    {
        int id = currentId++;
        toDo.setId(id);
        toDos.put(id, toDo);
        return id;
    }

    public static ToDo getToDo(int toDoId)
    {
        if(toDos.containsKey(toDoId)) {
            return toDos.get(toDoId);
        }
        return null;
    }

    public static void delToDo(int toDoId)
    {
        toDos.remove(toDoId);
    }
}
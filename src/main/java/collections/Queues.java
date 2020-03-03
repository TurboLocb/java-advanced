package collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Queues {
    public static void main(String[] args) {
        PersonForQueue person1 = new PersonForQueue(1);
        PersonForQueue person2 = new PersonForQueue(2);
        PersonForQueue person3 = new PersonForQueue(3);

        PersonForQueue person4 = new PersonForQueue(4);
        PersonForQueue person5 = new PersonForQueue(5);
        PersonForQueue person6 = new PersonForQueue(6);

        Queue<PersonForQueue> queue = new ArrayBlockingQueue<PersonForQueue>(10);
        queue.add(person3);
        queue.add(person1); //добавляет элемент в очередь, но вызывает исключение
        queue.add(person2);

        queue.offer(person4);
        queue.offer(person5); //добавляет элемент в очередь,, но не вызывает исключение
        queue.offer(person6);

        for (int i = 0; i < 3; i++){
            queue.remove(); //удаляет элементы из очереди, но вызывает исключение
        }

        for (int i = 0; i < 3; i++) {
            queue.poll(); //удаляет элементы из очереди, но не вызывает исключение
        }

        //System.out.println(queue.remove()); //удаляет элемент в начале списка (в нашем случае 'person3')

        System.out.println(queue.peek()); //чекает - существует ли элемент, но не вызывает исключение

        System.out.println(queue.element()); //чекает - существует ли элемент, но вызывает исключение

        System.out.println(queue);

        /*
        *
        * Таким образом методы
        * add(), remove(), element() возвращают в случае ошибки исключение
        * а методы offer(), poll(), peek() возвращают в случае ошибки некоторое значение (true/false)
        *
        */
    }
}

class PersonForQueue{
    private int id;

    public PersonForQueue(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonForQueue{" +
                "id=" + id +
                '}';
    }
}



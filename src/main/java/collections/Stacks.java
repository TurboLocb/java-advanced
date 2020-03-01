package collections;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //filo

        stack.push(5); //добавляем
        stack.push(3); //добавляем
        stack.push(1); //добавляем

        System.out.println(stack.pop()); //достаем
        System.out.println(stack.pop()); //достаем
        System.out.println(stack.pop()); //достаем

        System.out.println(stack.peek()); //чекаем элемент не доставая его из стека

        System.out.println(stack.empty()); //пустой или нет


    }
}

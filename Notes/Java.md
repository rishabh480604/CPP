Advanced Java
1) String Handling why is string immutable ? string vs stringBuilder vs StringBuffer
2) Object class == and equals
    == check addresss
    .equals if a.equ()als(b) the a.hashcode()= b.hashcode() but reverse can be false in collision
3) exception handling : throw and throws
    throw  is used explicitly create and throw an exception inside a method or block
    if(age<18){
        throw new Exception("UNder age");
    }
    throws is used in method declaration to indicate that method can throw exception
    public void fun() throws Exception{
        if(age<18){
            throw new Exception("You are under age.");
        }
    }
4) collection: Arraylist and linkedlist, hashmap vs concurrentHashMap
5) Generic: type erasure , wildcards, extends vs super
6) Java memory model: stack vs heap , object allocation , garbage collection
7) reflection: what and when
8) serialization : serializable. transient , serialVersionUID
9) Immutability: HOw do you create an immutable class?
10) abstract class vs interface
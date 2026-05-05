# paoj

Lab: **Object Serialization & Threads in Java**.

Fiecare clasa demo are propriul `main` si poate fi rulata independent
din IDE sau cu `java -cp target/classes <fully.qualified.ClassName>`.

## Serialization

### `org.example.serialization.intro`
- `Ex` — punte de la `B_io`: salveaza un `Book` (record) manual ca text linie cu linie cu `BufferedWriter`, il citeste si parseaza cu `BufferedReader`. Functioneaza, dar comentariile arata limitele (format inventat, parsare manuala, obiecte imbricate) -> motiveaza `ObjectOutputStream`.

### `org.example.serialization.basics`
- `Book` — domeniu `Serializable`, contine `serialVersionUID`, un camp `transient` si o referinta catre `Author`.
- `Author` — `Serializable`, referit de `Book` (graf de obiecte).
- `Library` — NU este `Serializable`; folosit pentru demo de exceptie.
- `Ex` — main: scrie/citeste un `Book` din `book.ser`, arata ca `transient` revine null si ca `Author`-ul referit este si el persistat.
- `NotSerializableDemo` — main: arata `NotSerializableException` cand un camp referit nu implementeaza `Serializable`.
- `VersionMismatchDemo` — main: arata `InvalidClassException` cand `serialVersionUID` din stream difera de cel al clasei locale.

### `org.example.serialization.externalizable`
- `Book` — domeniu `Externalizable` cu constructor public fara argumente; `writeExternal` scrie campurile in ordinea aleasa, sare peste `price`, ofuscheaza `secretNote`.
- `Ex` — main: serializare/deserializare custom; arata ca `price` revine 0.0 (nepersistat) si ca `secretNote` e dezofuscat la citire.

## Threads

### `org.example.threads.basics`
- `ThreadSubclassDemo` — extinde `Thread`; compara `run()` direct (ruleaza pe main, secvential) cu `start()` (concurenta reala).
- `RunnableDemo` — implementeaza `Runnable`; arata varianta preferata si bonus cu lambda.
- `JoinDemo` — pornire paralela a 4 task-uri, `join()` pe fiecare, comparatie de timp secvential vs paralel.
- `InterruptDemo` — thread cu bucla cooperanta care verifica `isInterrupted()` si trateaza `InterruptedException` pentru oprire graceful.

### `org.example.threads.synchronization`
- `CounterDemo` — race condition pe contor, fix cu `synchronized` pe metoda (lock pe `this`) si cu `synchronized` block (lock dedicat).
- `BankAccountDemo` — `deposit`/`withdraw` `synchronized`; soldul ramane consistent sub depuneri/retrageri concurente.

### `org.example.threads.producerconsumer`
- `PizzaCounter` — buffer marginit (capacity-bounded), `synchronized` `put`/`take` cu `wait()`/`notify()` si `while` in jurul `wait()` (spurious wakeups).
- `Cook` — producer: pune pizza pe tejghea.
- `Waiter` — consumer: ia pizza si o "livreaza".
- `Ex` — main: 2 producers, 1 consumer, ruleaza ~3s, apoi `interrupt()` + `join()` pentru oprire curata.

# paoj

Lab: **Object Serialization & Threads in Java**.

Continuare a labului trecut (`paoj-exceptions` -> `B_io`). Fiecare clasa
are propriul `main` si poate fi rulata independent din IDE sau cu
`java -cp target/classes <fully.qualified.ClassName>`.

## C_serialization

- **`a_intro/Ex`** — punte de la `B_io`: salveaza un `Book` (record) manual ca text linie cu linie cu `BufferedWriter`, il citeste cu `BufferedReader`. Comentariile listeaza limitele (format inventat, parsare manuala, obiecte imbricate) -> motiveaza `ObjectOutputStream`.
- **`b_serializable`** — `Book` (Serializable, `serialVersionUID`, `transient`, ref la `Author`), `Author`, `Ex`. Round-trip pe disc; `transient` revine null, `Author` e refacut automat (graf de obiecte).
- **`c_notserializable/Ex`** — `NotSerializableException` cand un camp referit nu implementeaza `Serializable`.
- **`d_versionmismatch/Ex`** — `InvalidClassException` cand `serialVersionUID` din stream difera de cel al clasei locale.
- **`e_externalizable`** — `Book` cu `Externalizable` si ctor public no-arg; `writeExternal` sare peste `price` -> dupa deserializare `price = 0.0`. Comentariu cu Serializable vs Externalizable.

## D_threads

- **`a_threadclass/Ex`** — extinde `Thread`; compara `run()` direct (pe main, secvential) cu `start()` (paralel).
- **`b_runnable/Ex`** — implementeaza `Runnable`; varianta preferata, plus lambda.
- **`c_join/Ex`** — pornire paralela a 3 task-uri, `join()` pe fiecare, ~500 ms (nu 1500).
- **`d_interrupt/Ex`** — bucla cooperanta care verifica `isInterrupted()` si trateaza `InterruptedException` pentru oprire graceful.
- **`e_race/Ex`** — race condition pe contor; fix cu `synchronized` method (lock pe `this`) si `synchronized` block (lock dedicat).
- **`f_bankaccount`** — `Account` cu `deposit`/`withdraw` `synchronized`; soldul ramane consistent.
- **`g_producerconsumer`** — `PizzaCounter` (bounded buffer, `wait`/`notify`, `while` in jurul `wait`), `Cook` producer, `Waiter` consumer, `Ex` ruleaza ~2s apoi `interrupt()` + `join()`.

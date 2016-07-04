# ShapeSerializer
Shape to XML/JSON serializer.

### Задача
Написати модуль для векторного редактора, що серіалізую графічні об'єкти в xml формат.

Дано декілька простих фігур - Rectangle, Circle, Triangle.

Разом з фігурою Group можуть утворювати ієрархічну структуру. (патерн Композит)

Інтерфейс серіалізатора виглядає наступним чином:

```java
public interface Serializer {
  void serialize(Shape shape, OutputStream out);
}
```

Жодних сторонніх бібліотек використовувати не можна.
Виключення junit.

Успіхів!

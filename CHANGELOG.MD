# Журнал изменений
## vX.X.X - XX.XX.XXXX
### Добавлено
* Добавлен AUTHOR.MD.
* Добавлен INSTALL.MD.
* Добавлен CHANGELOG.MD.

### Изменено
* Обновлён README.MD.

### Исправлено
*

## v1.3.0 - 16.10.2022
### Добавлено
* Добавлен метод Stringi.isPalindrome(String).
* Добавлен метод Stringi.isPalindromeIgnoreCase(String).
* Добавлен плагин maven-assembly в pom.xml.
* Добавлен плагин maven-compiler в pom.xml.
* Добавлен плагин maven-dependency в pom.xml.
* Добавлен плагин maven-javadoc в pom.xml.
* Добавлен плагин maven-source в pom.xml.
* Добавлена аннотация NotNull для возвращаемых значений.

## v1.2.0 - 31.08.2022
### Добавлено
* Добавлен метод Stringi.searchFirstLetter(String).
* Добавлен метод Stringi.searchLastLetter(String).
* Добавлен метод Stringi.toCharArray(String).
* Добавлен метод Stringi.toCharList(String).
* Добавлен метод Stringi.glue(List<Character>).

### Изменено
* Удалён метод Stringi.repeat(String).
* Удалён метод Stringi.isUpperCase(String).
* Удалён метод Stringi.isLowerCase(String).

## v1.1.0 - 02.08.2022
### Добавлено
* Добавлен метод Stringi.searchLast(String, Character).
* Добавлен метод Stringi.searchLast(String, List<Character>).
* Добавлен метод Stringi.searchFirst(String, List<Character>).
* Добавлен метод Stringi.repeat(String).
* Добавлен метод Stringi.shuffle(String).
* Добавлен метод Stringi.reverse(String).
* Добавлен метод Stringi.join(List<String>).
* Добавлен метод Stringi.repeatToLength(String, Integer)
* Добавлен метод Stringi.fillLeft(String, String, Integer).
* Добавлен метод Stringi.fill(String, String, Integer).
* Добавлен метод Stringi.fillRight(String, String, Integer).

### Изменено
* Переименован метод Stringi.search(String, Character) -> Stringi.searchFirst(String, Character).
* Удалён метод Stringi.isLatin().
* Удалён метод Stringi.isCyrillic().
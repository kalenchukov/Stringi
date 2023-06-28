/*
 * Copyright © 2022-2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.stringi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;

/**
 * Класс работы со строками под шуточным названием «стринги».
 *
 * @author Алексей Каленчуков
 */
public final class Stringi
{
	/**
	 * Конструктор для {@code Stringi}.
	 */
	private Stringi() {}

	/**
	 * Преобразовывает регистр первого символа к прописному.
	 *
	 * @param string строка.
	 * @return строку, в которой регистр первого символа преобразован в прописной.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String firstToUpperCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (!string.isEmpty()) {
			return String.valueOf(string.charAt(0)).toUpperCase() + string.substring(1);
		}

		return string;
	}

	/**
	 * Преобразовывает регистр первого символа к строчному.
	 *
	 * @param string строка.
	 * @return строку, в которой регистр первого символа преобразован в строчный.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String firstToLowerCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (!string.isEmpty()) {
			return String.valueOf(string.charAt(0)).toLowerCase() + string.substring(1);
		}

		return string;
	}

	/**
	 * Преобразовывает регистр первой найденной буквы к прописному.
	 *
	 * @param string строка.
	 * @return возвращает строку, в которой регистр первой буквы прописной.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String firstLetterToUpperCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		final Integer position = Stringi.searchFirstLetter(string);

		if (position != null)
		{
			StringBuilder newString = new StringBuilder();
			newString.append(string, 0, position);
			newString.append(string.substring(position, position + 1).toUpperCase());
			newString.append(string.substring(position + 1));

			return newString.toString();
		}

		return string;
	}

	/**
	 * Преобразовывает регистр первой найденной буквы к строчному.
	 *
	 * @param string строка.
	 * @return возвращает строку, в которой регистр первой буквы строчный.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String firstLetterToLowerCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		final Integer position = Stringi.searchFirstLetter(string);

		if (position != null)
		{
			StringBuilder newString = new StringBuilder();
			newString.append(string, 0, position);
			newString.append(string.substring(position, position + 1).toLowerCase());
			newString.append(string.substring(position + 1));

			return newString.toString();
		}

		return string;
	}

	/**
	 * Преобразовывает регистр букв в противоположный.
	 *
	 * @param string строка.
	 * @return строку, в которой регистр букв преобразован в противоположный.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String reverseCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		final StringBuilder newString = new StringBuilder();

		for (char character : string.toCharArray())
		{
			if (Character.isLowerCase(character)) {
				newString.append(Character.toUpperCase(character));
			} else {
				newString.append(Character.toLowerCase(character));
			}
		}

		return newString.toString();
	}

	/**
	 * Выполняет поиск первого вхождения символа в строке.
	 *
	 * @param string строка.
	 * @param symbol искомый символ.
	 * @return позицию первого вхождения {@code symbol} в {@code string} или {@code null} если {@code symbol} не найден.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@Nullable
	public static Integer searchFirst(@NotNull final String string, final char symbol)
	{
		Objects.requireNonNull(string);

		return Stringi.searchFirst(string, List.of(symbol));
	}

	/**
	 * Выполняет поиск последнего вхождения символа в строке.
	 *
	 * @param string строка.
	 * @param symbol искомый символ.
	 * @return позицию последнего вхождения {@code symbol} в {@code string} или {@code null} если {@code symbol} не найден.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@Nullable
	public static Integer searchLast(@NotNull final String string, final char symbol)
	{
		Objects.requireNonNull(string);

		return Stringi.searchLast(string, List.of(symbol));
	}

	/**
	 * Выполняет поиск первого вхождения одного из символов в строке.
	 *
	 * @param string строка.
	 * @param symbols коллекция искомых символов.
	 * @return позицию первого вхождения одного из символов в строке или {@code null} если
	 * ни один из символов из {@code symbols} не найден.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code symbols} передан {@code null}.
	 */
	@Nullable
	public static Integer searchFirst(@NotNull final String string, @NotNull final List<@NotNull Character> symbols)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(symbols);

		if (symbols.isEmpty()) {
			return null;
		}

		if (string.isEmpty()) {
			return null;
		}

		final char[] characters = string.toCharArray();

		for (int position = 0; position < characters.length; position++) {
			if (symbols.contains(characters[position])) {
				return position;
			}
		}

		return null;
	}

	/**
	 * Выполняет поиск первой буквы в строке.
	 *
	 * @param string строка.
	 * @return позицию первой буквы в {@code string} или {@code null} если букв нет.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@Nullable
	public static Integer searchFirstLetter(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (string.isEmpty()) {
			return null;
		}

		final char[] characters = string.toCharArray();

		for (int position = 0; position < characters.length; position++) {
			if (Character.isLetter(characters[position])) {
				return position;
			}
		}

		return null;
	}

	/**
	 * Выполняет поиск последней буквы в строке.
	 *
	 * @param string строка.
	 * @return позицию последней буквы в {@code string} или {@code null} если букв нет.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@Nullable
	public static Integer searchLastLetter(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (string.isEmpty()) {
			return null;
		}

		final char[] characters = string.toCharArray();

		for (int position = characters.length - 1; position >= 0; position--) {
			if (Character.isLetter(characters[position])) {
				return position;
			}
		}

		return null;
	}

	/**
	 * Выполняет поиск последнего вхождения одного из символов в строке.
	 *
	 * @param string строка.
	 * @param symbols коллекция искомых символов.
	 * @return позицию последнего вхождения одного из {@code symbols} в {@code string} или {@code null},
	 * если ни один из {@code symbols} не найден.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code symbols} передан {@code null}.
	 */
	@Nullable
	public static Integer searchLast(@NotNull final String string, @NotNull final List<@NotNull Character> symbols)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(symbols);

		if (symbols.isEmpty()) {
			return null;
		}

		if (string.isEmpty()) {
			return null;
		}

		final char[] characters = string.toCharArray();

		for (int position = characters.length - 1; position >= 0; position--) {
			if (symbols.contains(characters[position])) {
				return position;
			}
		}

		return null;
	}

	/**
	 * Выполняет повтор строки до заданного количества символов.
	 *
	 * @param string строка.
	 * @param length количество символов.
	 * @return строку, повторенную до {@code length} символов.
	 * @throws IllegalArgumentException если {@code length} меньше 0.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String repeatToLength(@NotNull final String string, final int length)
	{
		Objects.requireNonNull(string);

		if (length < 0) {
			throw new IllegalArgumentException();
		}

		if (string.isEmpty()) {
			return "";
		}

		StringBuilder newString = new StringBuilder();

		final char[] characters = string.toCharArray();
		int indexCharacter = 0;
		int needLength = length;

		while (needLength != 0)
		{
			newString.append(characters[indexCharacter]);

			indexCharacter++;
			needLength--;

			if (indexCharacter == characters.length) {
				indexCharacter = 0;
			}
		}

		return newString.toString();
	}

	/**
	 * Перемешивает символы в строке.
	 *
	 * @param string строка.
	 * @return строку, в которой порядок всех символов изменён случайным образом.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String shuffle(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (string.length() < 2) {
			return string;
		}

		final Character[] characters = Stringi.toCharArray(string);
		final int coefficient = (int) (characters.length * 2.5);
		final Random random = new Random();

		for (int iterationShuffle = 0; iterationShuffle < coefficient; iterationShuffle++)
		{
			int indexFrom = random.nextInt(characters.length);
			int indexIn = random.nextInt(characters.length);

			Stringi.swapValuesInArray(characters, indexFrom, indexIn);
		}

		return Stringi.glue(characters);
	}

	/**
	 * Переворачивает строку.
	 *
	 * @param string строка.
	 * @return строку, в которой все символы расположены в обратном порядке.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String reverse(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (string.length() < 2) {
			return string;
		}

		final Character[] characters = Stringi.toCharArray(string);

		for (int iterationReverse = 0; iterationReverse < characters.length / 2; iterationReverse++)
		{
			int indexFrom = (characters.length - iterationReverse) - 1;
			int indexIn = iterationReverse;

			Stringi.swapValuesInArray(characters, indexFrom, indexIn);
		}

		return Stringi.glue(characters);
	}

	/**
	 * Возвращает количество разнообразных символов в строке.
	 *
	 * @param string строка.
	 * @return количество разнообразных символов.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	public static int countVariousSymbols(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		Set<Character> variousSymbols = new HashSet<>();

		for (char symbol : string.toCharArray()) {
			variousSymbols.add(symbol);
		}

		return variousSymbols.size();
	}

	/**
	 * Проверяет, является ли строка палиндромом.
	 *
	 * @param string строка.
	 * @return {@code true}, если {@code string} является палиндромом, иначе {@code False}.
	 */
	public static boolean isPalindrome(@NotNull final String string)
	{
		return string.equals(Stringi.reverse(string));
	}

	/**
	 * Проверяет, является ли строка палиндромом без учёта регистра букв.
	 *
	 * @param string строка.
	 * @return {@code true}, если {@code string} является палиндромом, иначе {@code False}.
	 */
	public static boolean isPalindromeIgnoreCase(@NotNull final String string)
	{
		return string.equalsIgnoreCase(Stringi.reverse(string));
	}

	/**
	 * Склеивает символы в строку.
	 *
	 * @param symbols коллекция символов.
	 * @return строку из элементов коллекции.
	 * @throws NullPointerException если в качестве {@code symbols} передан {@code null}.
	 */
	@NotNull
	public static String glue(@NotNull final List<@Nullable Character> symbols)
	{
		Objects.requireNonNull(symbols);

		return Stringi.glue(symbols, "");
	}

	/**
	 * Склеивает символы в строку с разделителем.
	 *
	 * @param symbols коллекция символов.
	 * @param separator разделитель.
	 * @return строку из элементов коллекции.
	 * @throws NullPointerException если в качестве {@code symbols} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code separator} передан {@code null}.
	 */
	@NotNull
	public static String glue(@NotNull final List<@Nullable Character> symbols, @NotNull final String separator)
	{
		Objects.requireNonNull(symbols);
		Objects.requireNonNull(separator);

		return Stringi.glue(symbols.toArray(Character[]::new), separator);
	}

	/**
	 * Склеивает символы в строку.
	 *
	 * @param symbols массив символов.
	 * @return строку из элементов массива.
	 */
	@NotNull
	public static String glue(@Nullable final Character @NotNull [] symbols)
	{
		return Stringi.glue(symbols, "");
	}

	/**
	 * Склеивает символы в строку.
	 *
	 * @param symbols массив символов.
	 * @param separator разделитель символов.
	 * @return строку из элементов массива.
	 * @throws NullPointerException если в качестве {@code symbols} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code separator} передан {@code null}.
	 */
	@NotNull
	public static String glue(@Nullable final Character @NotNull [] symbols, @NotNull final String separator)
	{
		Objects.requireNonNull(symbols);
		Objects.requireNonNull(separator);

		final String[] strings = Arrays.stream(symbols)
									   .filter(Objects::nonNull)
									   .map(String::valueOf)
									   .toArray(String[]::new);

		return Stringi.join(strings, separator);
	}

	/**
	 * Объединяет строки.
	 *
	 * @param strings коллекция строк.
	 * @return строку из элементов коллекции.
	 * @throws NullPointerException если в качестве {@code strings} передан {@code null}.
	 */
	@NotNull
	public static String join(@NotNull final List<@Nullable String> strings)
	{
		Objects.requireNonNull(strings);

		return Stringi.join(strings, "");
	}

	/**
	 * Объединяет строки с разделителем.
	 *
	 * @param strings коллекция строк.
	 * @param separator разделитель.
	 * @return строку из элементов коллекции.
	 * @throws NullPointerException если в качестве {@code strings} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code separator} передан {@code null}.
	 */
	@NotNull
	public static String join(@NotNull final List<@Nullable String> strings, @NotNull final String separator)
	{
		Objects.requireNonNull(strings);
		Objects.requireNonNull(separator);

		return Stringi.join(strings.toArray(String[]::new), separator);
	}

	/**
	 * Объединяет строки.
	 *
	 * @param strings массив строк.
	 * @return строку из элементов массива.
	 * @throws NullPointerException если в качестве {@code strings} передан {@code null}.
	 */
	@NotNull
	public static String join(@Nullable final String @NotNull [] strings)
	{
		Objects.requireNonNull(strings);

		return Stringi.join(strings, "");
	}

	/**
	 * Объединяет строки с разделителем.
	 *
	 * @param strings массив строк.
	 * @param separator разделитель.
	 * @return строку из элементов массива.
	 * @throws NullPointerException если в качестве {@code strings} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code separator} передан {@code null}.
	 */
	@NotNull
	public static String join(@Nullable final String @NotNull [] strings, @NotNull final String separator)
	{
		Objects.requireNonNull(strings);
		Objects.requireNonNull(separator);

		if (strings.length == 0) {
			return "";
		}

		boolean addSeparator = false;

		final StringBuilder newString = new StringBuilder();

		for (String string : strings)
		{
			if (string == null) {
				continue;
			}

			if (addSeparator) {
				newString.append(separator);
			} else {
				addSeparator = true;
			}

			newString.append(string);
		}

		return newString.toString();
	}

	/**
	 * Дополняет строку другой строкой слева до заданного количества символов.
	 *
	 * @param string строка.
	 * @param filler наполнитель.
	 * @param length количество символов.
	 * @return исходную строку, дополненную строкой {@code filler} слева до {@code length} символов.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code filler} передан {@code null}.
	 * @throws IllegalArgumentException если {@code length} меньше 0.
	 */
	@NotNull
	public static String fillLeft(@NotNull final String string,
								  @NotNull final String filler, final int length)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(filler);

		if (length < 0) {
			throw new IllegalArgumentException();
		}

		if (string.length() >= length) {
			return string;
		}

		return Stringi.repeatToLength(filler, length - string.length()) + string;
	}

	/**
	 * Дополняет строку другой строкой слева и справа до заданного количества символов.
	 *
	 * @param string строка.
	 * @param filler наполнитель.
	 * @param length количество символов.
	 * @return исходную строку, дополненную строкой {@code filler} слева и справа до {@code length} символов.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code filler} передан {@code null}.
	 * @throws IllegalArgumentException если {@code length} меньше 0.
	 */
	@NotNull
	public static String fill(@NotNull final String string, @NotNull final String filler, final int length)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(filler);

		if (length < 0) {
			throw new IllegalArgumentException();
		}

		if (string.length() >= length) {
			return string;
		}

		return Stringi.repeatToLength(filler, (length - string.length()) / 2) + string +
			Stringi.repeatToLength(filler, (int) Math.ceil((double) (length - string.length()) / 2));
	}

	/**
	 * Дополняет строку другой строкой справа до заданного количества символов.
	 *
	 * @param string строка.
	 * @param filler наполнитель.
	 * @param length количество символов.
	 * @return исходную строку, дополненную строкой {@code filler} справа до {@code length} символов.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code filler} передан {@code null}.
	 * @throws IllegalArgumentException если {@code length} меньше 0.
	 */
	@NotNull
	public static String fillRight(@NotNull final String string, @NotNull final String filler, final int length)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(filler);

		if (length < 0) {
			throw new IllegalArgumentException();
		}

		if (string.length() >= length) {
			return string;
		}

		return string + Stringi.repeatToLength(filler, length - string.length());
	}

	/**
	 * Выполняет удаление символов пустого пространства в строке слева.
	 *
	 * @param string строка.
	 * @return исходную строку, с удалёнными символами пустого пространства слева.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String trimLeft(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		final StringBuilder newString = new StringBuilder(string);
		int trimLength = 0;

		for (int index = 0; index < string.length(); index++) {
			if (!Character.isWhitespace(newString.charAt(index))) {
				break;
			}

			trimLength++;
		}

		return newString.delete(0, trimLength).toString();
	}

	/**
	 * Выполняет удаление символов пустого пространства в строке справа.
	 *
	 * @param string строка.
	 * @return исходную строку, с удалёнными символами пустого пространства справа.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static String trimRight(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		final StringBuilder newString = new StringBuilder(string);
		int trimLength = string.length();

		for (int index = string.length() - 1; index >= 0; index--) {
			if (!Character.isWhitespace(newString.charAt(index))) {
				break;
			}

			trimLength--;
		}

		return newString.delete(trimLength, string.length()).toString();
	}

	/**
	 * Возвращает коллекцию из символов строки.
	 *
	 * @param string строка.
	 * @return коллекцию символов.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@Unmodifiable
	@NotNull
	public static List<Character> toCharList(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		return string.chars().mapToObj(i -> (char) i).toList();
	}

	/**
	 * Возвращает массив из символов строки.
	 *
	 * @param string строка.
	 * @return массив символов.
	 * @throws NullPointerException если в качестве {@code string} передан {@code null}.
	 */
	@NotNull
	public static Character @NotNull [] toCharArray(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		return string.chars().mapToObj(i -> (char) i).toArray(Character[]::new);
	}

	/**
	 * Меняет местами значения в массиве.
	 *
	 * @param array массив.
	 * @param from индекс массива из которого необходимо переместить значение.
	 * @param in индекс массива в который необходимо переместить значение.
	 * @throws IllegalArgumentException если {@code from} или {@code to} меньше 0.
	 * @throws IndexOutOfBoundsException если {@code from} или {@code to} выходят за пределы количества элементов в массиве.
	 */
	private static void swapValuesInArray(@Nullable final Character @NotNull [] array, final int from, final int in)
	{
		if (from < 0 || in < 0) {
			throw new IllegalArgumentException();
		}

		if (from > array.length || in > array.length) {
			throw new IndexOutOfBoundsException();
		}

		final char charTemp = array[in];

		array[in] = array[from];
		array[from] = charTemp;
	}
}

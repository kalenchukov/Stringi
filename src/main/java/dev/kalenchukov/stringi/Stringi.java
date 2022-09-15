/*
 * Copyright © 2022 Алексей Каленчуков
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
import org.jetbrains.annotations.Range;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;
/**
 * Класс работы со строками под шуточным названием "стринги".
 */
public class Stringi
{
	/**
	 * Конструктор для {@code Stringi} запрещающий создавать объект класса.
	 */
	private Stringi() {}

	/**
	 * Преобразовывает регистр первого символа к прописному.
	 *
	 * @param string Строка.
	 * @return Строку, в которой регистр первого символа преобразован в прописной.
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
	 * @param string Строка.
	 * @return Строку, в которой регистр первого символа преобразован в строчный.
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
	 * @param string Строка.
	 * @return Возвращает строку в которой регистр первой буквы прописной.
	 */
	@NotNull
	public static String firstLetterToUpperCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		final Integer position = Stringi.searchFirstLetter(string);

		if (position != null)
		{
			StringBuilder newString = new StringBuilder();
			newString.append(string.substring(0, position));
			newString.append(string.substring(position, position + 1).toUpperCase());
			newString.append(string.substring(position + 1));

			return newString.toString();
		}

		return string;
	}

	/**
	 * Преобразовывает регистр первой найденной буквы к строчному.
	 *
	 * @param string Строка.
	 * @return Возвращает строку в которой регистр первой буквы строчный.
	 */
	@NotNull
	public static String firstLetterToLowerCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		final Integer position = Stringi.searchFirstLetter(string);

		if (position != null)
		{
			StringBuilder newString = new StringBuilder();
			newString.append(string.substring(0, position));
			newString.append(string.substring(position, position + 1).toLowerCase());
			newString.append(string.substring(position + 1));

			return newString.toString();
		}

		return string;
	}

	/**
	 * Преобразовывает регистр букв в противоположный.
	 *
	 * @param string Строка.
	 * @return Строку в которой регистр букв преобразован в противоположный.
	 */
	@NotNull
	public static String reverseCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		final Character[] characters = Stringi.toCharArray(string);
		final StringBuilder newString = new StringBuilder();

		for (char character : characters)
		{
			if (Character.isLowerCase(character)) {
				newString.append(Character.toUpperCase(character));
			}
			else {
				newString.append(Character.toLowerCase(character));
			}
		}

		return newString.toString();
	}

	/**
	 * Выполняет поиск первого вхождения символа в строке.
	 *
	 * @param string Строка.
	 * @param symbol Искомый символ.
	 * @return Позицию первого вхождения символа в строке или {@code null} если символ не найден.
	 */
	@Nullable
	public static Integer searchFirst(@NotNull final String string, @NotNull final Character symbol)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(symbol);

		return Stringi.searchFirst(string, List.of(symbol));
	}

	/**
	 * Выполняет поиск последнего вхождения символа в строке.
	 *
	 * @param string Строка.
	 * @param symbol Искомый символ.
	 * @return Позицию последнего вхождения символа в строке или {@code null} если символ не найден.
	 */
	@Nullable
	public static Integer searchLast(@NotNull final String string, @NotNull final Character symbol)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(symbol);

		return Stringi.searchLast(string, List.of(symbol));
	}

	/**
	 * Выполняет поиск первого вхождения одного из символов в строке.
	 *
	 * @param string Строка.
	 * @param symbols Коллекция искомых символов.
	 * @return Позицию первого вхождения одного из символов в строке или {@code null} если ни один из символов не найден.
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

		final Character[] characters = Stringi.toCharArray(string);

		for (int position = 0; position < characters.length; position++)
		{
			if (symbols.contains(characters[position])) {
				return position;
			}
		}

		return null;
	}

	/**
	 * Выполняет поиск первой буквы в строке.
	 *
	 * @param string Строка.
	 * @return Позицию первой буквы в строке или {@code null} если ни один из символов не найден.
	 */
	@Nullable
	public static Integer searchFirstLetter(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (string.isEmpty()) {
			return null;
		}

		final Character[] characters = Stringi.toCharArray(string);

		for (int position = 0; position < characters.length; position++)
		{
			if (Character.isLetter(characters[position])) {
				return position;
			}
		}

		return null;
	}

	/**
	 * Выполняет поиск последней буквы в строке.
	 *
	 * @param string Строка.
	 * @return Позицию последней буквы в строке или {@code null} если ни один из символов не найден.
	 */
	@Nullable
	public static Integer searchLastLetter(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (string.isEmpty()) {
			return null;
		}

		final Character[] characters = Stringi.toCharArray(string);

		for (int position = characters.length - 1; position >= 0; position--)
		{
			if (Character.isLetter(characters[position])) {
				return position;
			}
		}

		return null;
	}

	/**
	 * Выполняет поиск последнего вхождения одного из символов в строке.
	 *
	 * @param string Строка.
	 * @param symbols Коллекция искомых символов.
	 * @return Позицию последнего вхождения одного из символов в строке или {@code null}, если ни один из символов не найден.
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

		final Character[] characters = Stringi.toCharArray(string);

		for (int position = characters.length - 1; position >= 0; position--)
		{
			if (symbols.contains(characters[position])) {
				return position;
			}
		}

		return null;
	}

	/**
	 * Выполняет повтор строки до заданного количества символов.
	 *
	 * @param string Строка.
	 * @param length Количество символов.
	 * @return Строку, повторенную до {@code length} символов.
	 * @throws IllegalArgumentException Если {@code length} меньше нуля.
	 */
	public static String repeatToLength(@NotNull final String string,
										@NotNull @Range(from = 0, to = Integer.MAX_VALUE) final Integer length)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(length);

		if (length < 0) {
			throw new IllegalArgumentException();
		}

		if (string.isEmpty()) {
			return "";
		}

		StringBuilder newString = new StringBuilder();

		final Character[] characters = Stringi.toCharArray(string);
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
	 * @param string Строка.
	 * @return Строку в которой порядок всех символов изменён случайным образом.
	 */
	@NotNull
	public static String shuffle(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (string.length() < 2) {
			return string;
		}

		Character[] characters = Stringi.toCharArray(string);
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
	 * @param string Строка.
	 * @return Строку в которой все символы расположены в обратном порядке.
	 */
	@NotNull
	public static String reverse(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		if (string.length() < 2) {
			return string;
		}

		Character[] characters = Stringi.toCharArray(string);

		for (int iterationReverse = 0; iterationReverse < characters.length / 2; iterationReverse++)
		{
			int indexFrom = (characters.length - iterationReverse) - 1;
			int indexIn = iterationReverse;

			Stringi.swapValuesInArray(characters, indexFrom, indexIn);
		}

		return Stringi.glue(characters);
	}

	/**
	 * Проверяет, является ли строка палиндромом.
	 *
	 * @param string Строка.
	 * @return {@code True}, если строка является палиндромом, иначе {@code False}.
	 */
	public static boolean isPalindrome(@NotNull final String string)
	{
		return string.equals(Stringi.reverse(string));
	}

	/**
	 * Проверяет, является ли строка палиндромом без учёта регистра букв.
	 *
	 * @param string Строка.
	 * @return {@code True}, если строка является палиндромом, иначе {@code False}.
	 */
	public static boolean isPalindromeIgnoreCase(@NotNull final String string)
	{
		return string.equalsIgnoreCase(Stringi.reverse(string));
	}

	/**
	 * Склеивает символы в строку.
	 *
	 * @param symbols Коллекция символов.
	 * @return Строку из элементов коллекции.
	 */
	public static String glue(@NotNull final List<@Nullable Character> symbols)
	{
		Objects.requireNonNull(symbols);

		return Stringi.glue(symbols, "");
	}

	/**
	 * Склеивает символы в строку с разделителем.
	 *
	 * @param symbols Коллекция символов.
	 * @param separator Разделитель.
	 * @return Строку из элементов коллекции.
	 */
	public static String glue(@NotNull final List<@Nullable Character> symbols, @NotNull final String separator)
	{
		Objects.requireNonNull(symbols);
		Objects.requireNonNull(separator);

		return Stringi.glue(symbols.toArray(Character[]::new), separator);
	}

	/**
	 * Склеивает символы в строку.
	 *
	 * @param symbols Массив символов.
	 * @return Строку из элементов массива.
	 */
	public static String glue(@Nullable final Character @NotNull [] symbols)
	{
		Objects.requireNonNull(symbols);

		return Stringi.glue(symbols, "");
	}

	/**
	 * Склеивает символы в строку.
	 *
	 * @param symbols Массив символов.
	 * @return Строку из элементов массива.
	 */
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
	 * @param strings Коллекция строк.
	 * @return Строку из элементов коллекции.
	 */
	public static String join(@NotNull final List<@Nullable String> strings)
	{
		Objects.requireNonNull(strings);

		return Stringi.join(strings, "");
	}

	/**
	 * Объединяет строки с разделителем.
	 *
	 * @param strings Коллекция строк.
	 * @param separator Разделитель.
	 * @return Строку из элементов коллекции.
	 */
	public static String join(@NotNull final List<@Nullable String> strings, @NotNull final String separator)
	{
		Objects.requireNonNull(strings);
		Objects.requireNonNull(separator);

		return Stringi.join(strings.toArray(String[]::new), separator);
	}

	/**
	 * Объединяет строки.
	 *
	 * @param strings Массив строк.
	 * @return Строку из элементов массива.
	 */
	public static String join(@Nullable final String @NotNull [] strings)
	{
		Objects.requireNonNull(strings);

		return Stringi.join(strings, "");
	}

	/**
	 * Объединяет строки с разделителем.
	 *
	 * @param strings Массив строк.
	 * @param separator Разделитель.
	 * @return Строку из элементов массива.
	 */
	public static String join(@Nullable final String @NotNull [] strings, @NotNull final String separator)
	{
		Objects.requireNonNull(strings);
		Objects.requireNonNull(separator);

		if (strings.length == 0) {
			return "";
		}

		boolean addSeparator = false;

		StringBuilder newString = new StringBuilder();

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
	 * @param string Строка.
	 * @param filler Наполнитель.
	 * @param length Количество символов.
	 * @return Исходную строку, дополненную строкой {@code filler} слева до {@code length} символов.
	 * @throws IllegalArgumentException Если {@code length} меньше нуля.
	 */
	@NotNull
	public static String fillLeft(@NotNull final String string,
								  @NotNull final String filler,
								  @NotNull @Range(from = 0, to = Integer.MAX_VALUE) final Integer length)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(filler);
		Objects.requireNonNull(length);

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
	 * @param string Строка.
	 * @param filler Наполнитель.
	 * @param length Количество символов.
	 * @return Исходную строку, дополненную строкой {@code filler} слева и справа до {@code length} символов.
	 * @throws IllegalArgumentException Если {@code length} меньше нуля.
	 */
	@NotNull
	public static String fill(@NotNull final String string,
							  @NotNull final String filler,
							  @NotNull @Range(from = 0, to = Integer.MAX_VALUE) final Integer length)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(filler);
		Objects.requireNonNull(length);

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
	 * @param string Строка.
	 * @param filler Наполнитель.
	 * @param length Количество символов.
	 * @return Исходную строку, дополненную строкой {@code filler} справа до {@code length} символов.
	 * @throws IllegalArgumentException Если {@code length} меньше нуля.
	 */
	@NotNull
	public static String fillRight(@NotNull final String string,
								   @NotNull final String filler,
								   @NotNull @Range(from = 0, to = Integer.MAX_VALUE) final Integer length)
	{
		Objects.requireNonNull(string);
		Objects.requireNonNull(filler);
		Objects.requireNonNull(length);

		if (length < 0) {
			throw new IllegalArgumentException();
		}

		if (string.length() >= length) {
			return string;
		}

		return string + Stringi.repeatToLength(filler, length - string.length());
	}

	/**
	 * Возвращает коллекцию из символов строки.
	 *
	 * @param string Строка.
	 * @return Коллекцию символов.
	 */
	@Unmodifiable
	@NotNull
	public static  List<Character> toCharList(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		return string.chars().mapToObj(i -> (char) i).toList();
	}

	/**
	 * Возвращает массив из символов строки.
	 *
	 * @param string Строка.
	 * @return Массив символов.
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
	 * @param array Массив.
	 * @param from Индекс массива из которого необходимо переместить значение.
	 * @param in Индекс массива в который необходимо переместить значение.
	 * @throws IllegalArgumentException Если {@code from} или {@code to} меньше нуля.
	 * @throws IndexOutOfBoundsException Если {@code from} или {@code to} больше размера массива.
	 */
	private static void swapValuesInArray(@Nullable final Character @NotNull [] array,
										  @NotNull @Range(from = 0, to = Integer.MAX_VALUE) final Integer from,
										  @NotNull @Range(from = 0, to = Integer.MAX_VALUE) final Integer in)
	{
		Objects.requireNonNull(array);
		Objects.requireNonNull(from);
		Objects.requireNonNull(in);

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

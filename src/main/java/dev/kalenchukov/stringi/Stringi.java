/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.stringi;

import dev.kalenchukov.alphabet.EnglishAlphabet;
import dev.kalenchukov.alphabet.RussianAlphabet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

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
	 * Проверяет, является ли буква строчной.<br>
	 * Поддерживаемые алфавиты:
	 * <ul>
	 *     <li>Русский</li>
	 *     <li>Английский</li>
	 * </ul>
	 *
	 * @param letter Буква.
	 * @return {@code True}, если буква строчная, иначе {@code false}.
	 */
	public static boolean isLowerCase(final char letter)
	{
		return RussianAlphabet.LETTERS_LOWER_CASE.contains(letter) ||
			EnglishAlphabet.LETTERS_LOWER_CASE.contains(letter);
	}

	/**
	 * Проверяет, является ли буква прописной.<br>
	 * Поддерживаемые алфавиты:
	 * <ul>
	 *     <li>Русский</li>
	 *     <li>Английский</li>
	 * </ul>
	 *
	 * @param letter Буква.
	 * @return {@code True}, если буква прописная, иначе {@code false}.
	 */
	public static boolean isUpperCase(final char letter)
	{
		return RussianAlphabet.LETTERS_UPPER_CASE.contains(letter) ||
			EnglishAlphabet.LETTERS_UPPER_CASE.contains(letter);
	}

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
	 * Преобразовывает регистр первой найденной буквы к прописному.<br>
	 * Поддерживаемые алфавиты:
	 * <ul>
	 *     <li>Русский</li>
	 *     <li>Английский</li>
	 * </ul>
	 *
	 * @param string Строка.
	 * @return Возвращает строку в которой регистр первой буквы прописной.
	 */
	@NotNull
	public static String firstLetterToUpperCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		List<Character> alphabets = new ArrayList<>(
			RussianAlphabet.LETTERS.size() + EnglishAlphabet.LETTERS.size()
		);
		alphabets.addAll(RussianAlphabet.LETTERS);
		alphabets.addAll(EnglishAlphabet.LETTERS);

		Integer position = Stringi.searchFirst(string, alphabets);

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
	 * Преобразовывает регистр первой найденной буквы к строчному.<br>
	 * Поддерживаемые алфавиты:
	 * <ul>
	 *     <li>Русский</li>
	 *     <li>Английский</li>
	 * </ul>
	 *
	 * @param string Строка.
	 * @return Возвращает строку в которой регистр первой буквы строчный.
	 */
	@NotNull
	public static String firstLetterToLowerCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		List<Character> alphabets = new ArrayList<>(
			RussianAlphabet.LETTERS.size() + EnglishAlphabet.LETTERS.size()
		);
		alphabets.addAll(RussianAlphabet.LETTERS);
		alphabets.addAll(EnglishAlphabet.LETTERS);

		Integer position = Stringi.searchFirst(string, alphabets);

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

		StringBuilder newString = new StringBuilder();

		for (char character : string.toCharArray())
		{
			if (Stringi.isLowerCase(character)) {
				newString.append(String.valueOf(character).toUpperCase());
			}
			else {
				newString.append(String.valueOf(character).toLowerCase());
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
	public static Integer searchFirst(@NotNull final String string, final char symbol)
	{
		Objects.requireNonNull(string);

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
	public static Integer searchLast(@NotNull final String string, final char symbol)
	{
		Objects.requireNonNull(string);

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

		final char[] stringCharacters = string.toCharArray();

		for (int position = 0; position < stringCharacters.length; position++)
		{
			if (symbols.contains(stringCharacters[position])) {
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
	 * @return Позицию последнего вхождения одного из символов в строке или {@code null} если ни один из символов не найден.
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

		final char[] stringCharacters = string.toCharArray();

		for (int position = stringCharacters.length - 1; position >= 0; position--)
		{
			if (symbols.contains(stringCharacters[position])) {
				return position;
			}
		}

		return null;
	}

	/**
	 * Выполняет повтор строки.
	 *
	 * @param string Строка.
	 * @param count Количество повторений.
	 * @return Строку, повторенную указанное количество раз.
	 * @throws IllegalArgumentException Если {@code count} меньше или равно нулю.
	 */
	@NotNull
	public static String repeat(@NotNull final String string,
								@Range(from = 1, to = Long.MAX_VALUE) final int count)
	{
		Objects.requireNonNull(string);

		if (count < 1) {
			throw new IllegalArgumentException();
		}

		StringBuilder newString = new StringBuilder(string);

		for (int iterationRepeat = 1; iterationRepeat < count; iterationRepeat++) {
			newString.append(string);
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

		char[] stringCharacters = string.toCharArray();
		final int coefficientShuffle = (int) (stringCharacters.length * 2.5);
		Random random = new Random();

		for (int iterationShuffle = 0; iterationShuffle < coefficientShuffle; iterationShuffle++)
		{
			int indexFrom = random.nextInt(stringCharacters.length);
			int indexIn = random.nextInt(stringCharacters.length);

			Stringi.swapValuesInArray(stringCharacters, indexFrom, indexIn);
		}

		return new String(stringCharacters);
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

		char[] stringCharacters = string.toCharArray();

		for (int iterationReverse = 0; iterationReverse < stringCharacters.length / 2; iterationReverse++)
		{
			int indexFrom = (stringCharacters.length - iterationReverse) - 1;
			int indexIn = iterationReverse;

			Stringi.swapValuesInArray(stringCharacters, indexFrom, indexIn);
		}

		return new String(stringCharacters);
	}

	/**
	 * Объединяет элементы коллекции в строку.
	 *
	 * @param values Коллекция значений из которого необходимо сделать строку.
	 * @return Строку из элементов коллекции.
	 */
	public static String join(@NotNull final List<@NotNull String> values)
	{
		Objects.requireNonNull(values);

		return Stringi.join(values, "");
	}

	/**
	 * Объединяет элементы коллекции в строку.
	 *
	 * @param values Коллекция значений из которого необходимо сделать строку.
	 * @param separator Разделитель.
	 * @return Строку из элементов коллекции.
	 */
	public static String join(@NotNull final List<@NotNull String> values, @NotNull final String separator)
	{
		Objects.requireNonNull(values);
		Objects.requireNonNull(separator);

		return Stringi.join(values.toArray(String[]::new), separator);
	}

	/**
	 * Объединяет элементы массива в строку.
	 *
	 * @param values Массив значений из которого необходимо сделать строку.
	 * @return Строку из элементов массива.
	 */
	public static String join(@NotNull final String @NotNull [] values)
	{
		Objects.requireNonNull(values);

		return Stringi.join(values, "");
	}

	/**
	 * Объединяет элементы массива в строку с разделителем.
	 *
	 * @param values Массив значений из которого необходимо сделать строку.
	 * @param separator Разделитель.
	 * @return Строку из элементов массива.
	 */
	public static String join(@NotNull final String @NotNull [] values, @NotNull final String separator)
	{
		Objects.requireNonNull(values);
		Objects.requireNonNull(separator);

		if (values.length == 0) {
			return "";
		}

		boolean addSeparator = false;

		StringBuilder newString = new StringBuilder();

		for (String string : values)
		{
			Objects.requireNonNull(string);

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
	 * Меняет местами значения в массиве.
	 *
	 * @param array Массив.
	 * @param from Индекс массива из которого необходимо переместить значение.
	 * @param in Индекс массива в который необходимо переместить значение.
	 * @throws IllegalArgumentException Если {@code from} или {@code to} меньше нуля.
	 * @throws IndexOutOfBoundsException Если {@code from} или {@code to} больше размера массива.
	 */
	private static void swapValuesInArray(final char[] array,
										  @Range(from = 0, to = Integer.MAX_VALUE) final int from,
										  @Range(from = 0, to = Integer.MAX_VALUE) final int in)
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

/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.stringi;

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
	 * Буквы кириллического алфавита.
	 */
	@NotNull
	private static final Character[] CYRILLIC = {
		// Строчные
		'\u0430', '\u0431', '\u0432', '\u0433', '\u0434', '\u0435',
		'\u0451', '\u0436', '\u0437', '\u0438', '\u0439', '\u043A',
		'\u043B', '\u043C', '\u043D', '\u043E', '\u043F', '\u0440',
		'\u0441', '\u0442', '\u0443', '\u0444', '\u0445', '\u0446',
		'\u0447', '\u0448', '\u0449', '\u044A', '\u044B', '\u044C',
		'\u044D', '\u044E', '\u044F',
		// Прописные
		'\u0410', '\u0411', '\u0412', '\u0413', '\u0414', '\u0415',
		'\u0401', '\u0416', '\u0417', '\u0418', '\u0419', '\u041A',
		'\u041B', '\u041C', '\u041D', '\u041E', '\u041F', '\u0420',
		'\u0421', '\u0422', '\u0423', '\u0424', '\u0425', '\u0426',
		'\u0427', '\u0428', '\u0429', '\u042A', '\u042B', '\u042C',
		'\u042D', '\u042E', '\u042F'
	};

	/**
	 * Строчные буквы кириллического алфавита.
	 */
	@NotNull
	private static final Character[] CYRILLIC_LOWER_CASE =
		Arrays.copyOfRange(CYRILLIC, 0, CYRILLIC.length / 2);

	/**
	 * Прописные буквы кириллического алфавита.
	 */
	@NotNull
	private static final Character[] CYRILLIC_UPPER_CASE =
		Arrays.copyOfRange(CYRILLIC, CYRILLIC.length / 2, CYRILLIC.length);

	/**
	 * Буквы латинского алфавита.
	 */
	@NotNull
	private static final Character[] LATIN = {
		// Строчные
		'\u0061', '\u0062', '\u0063', '\u0064', '\u0065', '\u0066',
		'\u0067', '\u0068', '\u0069', '\u006A', '\u006B', '\u006C',
		'\u006D', '\u006E', '\u006F', '\u0070', '\u0071', '\u0072',
		'\u0073', '\u0074', '\u0075', '\u0076', '\u0077', '\u0078',
		'\u0079', '\u007A',
		// Прописные
		'\u0041', '\u0042', '\u0043', '\u0044', '\u0045', '\u0046',
		'\u0047', '\u0048', '\u0049', '\u004A', '\u004B', '\u004C',
		'\u004D', '\u004E', '\u004F', '\u0050', '\u0051', '\u0052',
		'\u0053', '\u0054', '\u0055', '\u0056', '\u0057', '\u0058',
		'\u0059', '\u005A'
	};

	/**
	 * Строчные буквы латинского алфавита.
	 */
	@NotNull
	private static final Character[] LATIN_LOWER_CASE =
		Arrays.copyOfRange(LATIN, 0, LATIN.length / 2);

	/**
	 * Прописные буквы латинского алфавита.
	 */
	@NotNull
	private static final Character[] LATIN_UPPER_CASE =
		Arrays.copyOfRange(LATIN, LATIN.length / 2, LATIN.length);

	/**
	 * Конструктор для {@code Stringi} запрещающий создавать объект класса.
	 */
	private Stringi() {}

	/**
	 * Проверяет, принадлежит ли буква к латинскому алфавиту.
	 *
	 * @param letter Буква.
	 * @return {@code True}, если буква принадлежит латинскому алфавиту, иначе {@code false}.
	 */
	public static boolean isLatin(final char letter)
	{
		return List.of(LATIN).contains(letter);
	}

	/**
	 * Проверяет, является ли буква строчной.<br>
	 * Поддерживаемые алфавиты:
	 * <ul>
	 *     <li>Латиница</li>
	 *     <li>Кириллица</li>
	 * </ul>
	 *
	 * @param letter Буква.
	 * @return {@code True}, если буква строчная, иначе {@code false}.
	 */
	public static boolean isLowerCase(final char letter)
	{
		return List.of(CYRILLIC_LOWER_CASE).contains(letter) ||
			List.of(LATIN_LOWER_CASE).contains(letter);
	}

	/**
	 * Проверяет, является ли буква прописной.<br>
	 * Поддерживаемые алфавиты:
	 * <ul>
	 *     <li>Латиница</li>
	 *     <li>Кириллица</li>
	 * </ul>
	 *
	 * @param letter Буква.
	 * @return {@code True}, если буква прописная, иначе {@code false}.
	 */
	public static boolean isUpperCase(final char letter)
	{
		return List.of(CYRILLIC_UPPER_CASE).contains(letter) ||
			List.of(LATIN_UPPER_CASE).contains(letter);
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
	 *     <li>Латиница</li>
	 *     <li>Кириллица</li>
	 * </ul>
	 *
	 * @param string Строка.
	 * @return Возвращает строку в которой регистр первой буквы прописной.
	 */
	@NotNull
	public static String firstLetterToUpperCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		List<Character> alphabets = new ArrayList<>(CYRILLIC.length + LATIN.length);
		alphabets.addAll(List.of(CYRILLIC));
		alphabets.addAll(List.of(LATIN));

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
	 *     <li>Латиница</li>
	 *     <li>Кириллица</li>
	 * </ul>
	 *
	 * @param string Строка.
	 * @return Возвращает строку в которой регистр первой буквы строчный.
	 */
	@NotNull
	public static String firstLetterToLowerCase(@NotNull final String string)
	{
		Objects.requireNonNull(string);

		List<Character> alphabets = new ArrayList<>(CYRILLIC.length + LATIN.length);
		alphabets.addAll(List.of(CYRILLIC));
		alphabets.addAll(List.of(LATIN));

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

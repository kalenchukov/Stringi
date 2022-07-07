/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.stringi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
	 * Проверяет, принадлежит ли буква к кириллическому алфавиту.
	 *
	 * @param letter Буква.
	 * @return {@code True}, если буква принадлежит кириллическому алфавиту, иначе {@code false}.
	 */
	public static boolean isCyrillic(final char letter)
	{
		return List.of(CYRILLIC).contains(letter);
	}

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

		if (string.length() > 0) {
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

		if (string.length() > 0) {
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
			StringBuilder value = new StringBuilder();
			value.append(string.substring(0, position));
			value.append(string.substring(position, position + 1).toUpperCase());
			value.append(string.substring(position + 1));

			return value.toString();
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
			StringBuilder value = new StringBuilder();
			value.append(string.substring(0, position));
			value.append(string.substring(position, position + 1).toLowerCase());
			value.append(string.substring(position + 1));

			return value.toString();
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

		StringBuilder value = new StringBuilder();

		for (char character : string.toCharArray())
		{
			if (Stringi.isLowerCase(character)) {
				value.append(String.valueOf(character).toUpperCase());
			}
			else {
				value.append(String.valueOf(character).toLowerCase());
			}
		}

		return value.toString();
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

		char[] valueCharacters = string.toCharArray();

		for (int position = 0; position < valueCharacters.length; position++)
		{
			if (symbols.contains(valueCharacters[position])) {
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

		char[] valueCharacters = string.toCharArray();

		for (int position = valueCharacters.length - 1; position >= 0; position--)
		{
			if (symbols.contains(valueCharacters[position])) {
				return position;
			}
		}

		return null;
	}
}

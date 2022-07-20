/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.stringi;

import dev.kalenchukov.alphabet.EnglishAlphabet;
import dev.kalenchukov.alphabet.RussianAlphabet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StringiTest
{
	public static final Character[] SYMBOLS = {
		'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+',
		',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@',
		'[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'
	};

	/**
	 * Проверка если передана строчная буква.
	 */
	@Test
	public void testIsLowerCase1()
	{
		for (char character : RussianAlphabet.LETTERS_LOWER_CASE)
		{
			assertTrue(Stringi.isLowerCase(character));
		}

		for (char character : EnglishAlphabet.LETTERS_LOWER_CASE)
		{
			assertTrue(Stringi.isLowerCase(character));
		}
	}

	/**
	 * Проверка если передана прописная буква.
	 */
	@Test
	public void testIsLowerCase2()
	{
		for (char character : RussianAlphabet.LETTERS_UPPER_CASE)
		{
			assertFalse(Stringi.isLowerCase(character));
		}

		for (char character : EnglishAlphabet.LETTERS_UPPER_CASE)
		{
			assertFalse(Stringi.isLowerCase(character));
		}
	}

	/**
	 * Проверка если передана не буква, а символ.
	 */
	@Test
	public void testIsLowerCase3()
	{
		for (char character : SYMBOLS)
		{
			assertFalse(Stringi.isLowerCase(character));
		}
	}

	/**
	 * Проверка если передана прописная буква.
	 */
	@Test
	public void testIsUpperCase1()
	{
		for (char character : RussianAlphabet.LETTERS_UPPER_CASE)
		{
			assertTrue(Stringi.isUpperCase(character));
		}

		for (char character : EnglishAlphabet.LETTERS_UPPER_CASE)
		{
			assertTrue(Stringi.isUpperCase(character));
		}
	}

	/**
	 * Проверка если передана строчная буква.
	 */
	@Test
	public void testIsUpperCase2()
	{
		for (char character : RussianAlphabet.LETTERS_LOWER_CASE)
		{
			assertFalse(Stringi.isUpperCase(character));
		}

		for (char character : EnglishAlphabet.LETTERS_LOWER_CASE)
		{
			assertFalse(Stringi.isUpperCase(character));
		}
	}

	/**
	 * Проверка если передана не буква, а символ.
	 */
	@Test
	public void testIsUpperCase3()
	{
		for (char character : SYMBOLS)
		{
			assertFalse(Stringi.isUpperCase(character));
		}
	}

	/**
	 * Проверка преобразования первого символа к строчному.
	 */
	@Test
	public void testFirstToLowerCase()
	{
		assertEquals("", Stringi.firstToLowerCase(""));
		assertEquals("п", Stringi.firstToLowerCase("П"));
		assertEquals("пРИВЕТ", Stringi.firstToLowerCase("ПРИВЕТ"));
		assertEquals("_ПРИВЕТ", Stringi.firstToLowerCase("_ПРИВЕТ"));
	}

	/**
	 * Проверка преобразования первого символа к прописному.
	 */
	@Test
	public void testFirstToUpperCase()
	{
		assertEquals("", Stringi.firstToUpperCase(""));
		assertEquals("П", Stringi.firstToUpperCase("п"));
		assertEquals("Привет", Stringi.firstToUpperCase("привет"));
		assertEquals("_привет", Stringi.firstToUpperCase("_привет"));
	}

	/**
	 * Проверка преобразования регистра первой найденной буквы к прописному.
	 */
	@Test
	public void firstLetterToUpperCase()
	{
		assertEquals("", Stringi.firstLetterToUpperCase(""));
		assertEquals("П", Stringi.firstLetterToUpperCase("п"));
		assertEquals("Привет", Stringi.firstLetterToUpperCase("привет"));
		assertEquals("Ппривет", Stringi.firstLetterToUpperCase("ппривет"));
		assertEquals("_-Привет", Stringi.firstLetterToUpperCase("_-привет"));
		assertEquals("_-/*-/-/*", Stringi.firstLetterToUpperCase("_-/*-/-/*"));
	}

	/**
	 * Проверка преобразования регистра первой найденной буквы к строчному.
	 */
	@Test
	public void firstLetterToLowerCase()
	{
		assertEquals("", Stringi.firstLetterToLowerCase(""));
		assertEquals("п", Stringi.firstLetterToLowerCase("П"));
		assertEquals("пРИВЕТ", Stringi.firstLetterToLowerCase("ПРИВЕТ"));
		assertEquals("пПРИВЕТ", Stringi.firstLetterToLowerCase("ППРИВЕТ"));
		assertEquals("_-пРИВЕТ", Stringi.firstLetterToLowerCase("_-ПРИВЕТ"));
		assertEquals("_-/*-/-/*", Stringi.firstLetterToLowerCase("_-/*-/-/*"));
	}

	/**
	 * Проверка преобразования регистра букв в противоположный.
	 */
	@Test
	public void testReverseCase()
	{
		assertEquals("привет", Stringi.reverseCase("ПРИВЕТ"));
		assertEquals("ПРИВЕТ", Stringi.reverseCase("привет"));
		assertEquals("ПрИвЕт", Stringi.reverseCase("пРиВеТ"));
	}

	/**
	 * Проверка поиска первого вхождения символа в строке.
	 */
	@Test
	public void testSearchFirstSymbol()
	{
		Integer result = Stringi.searchFirst("Красно-жёлтые дни - песня группы Кино", '-');

		assert result != null;

		assertEquals(6, (int) result);
	}

	/**
	 * Проверка поиска последнего вхождения символа в строке.
	 */
	@Test
	public void testSearchLastSymbol()
	{
		Integer result = Stringi.searchLast("Красно-жёлтые дни - песня группы Кино", '-');

		assert result != null;

		assertEquals(18, (int) result);
	}

	/**
	 * Проверка поиска первого вхождения одного из символов в строке.
	 */
	@Test
	public void testSearchFirstSymbols()
	{
		Integer result = null;

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of());
		assertNull(result);

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('М'));
		assert result != null;
		assertEquals(0, (int) result);

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('.'));
		assert result != null;
		assertEquals(46, (int) result);

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('е'));
		assert result != null;
		assertEquals(11, (int) result);

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('ж', ','));
		assert result != null;
		assertEquals(4, (int) result);
	}

	/**
	 * Проверка поиска последнего вхождения одного из символов в строке.
	 */
	@Test
	public void testSearchLastSymbols()
	{
		Integer result = null;

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of());
		assertNull(result);

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('М'));
		assert result != null;
		assertEquals(0, (int) result);

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('.'));
		assert result != null;
		assertEquals(46, (int) result);

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('е'));
		assert result != null;
		assertEquals(30, (int) result);

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('ж', ','));
		assert result != null;
		assertEquals(15, (int) result);
	}

	/**
	 * Проверка повторения строки.
	 */
	@Test
	public void testRepeat()
	{
		String result = Stringi.repeat("Муравейник", 2);

		assertEquals("МуравейникМуравейник", result);
	}

	/**
	 * Проверка повторения строки отрицательное количество раз.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRepeatCountNegative()
	{
		Stringi.repeat("Муравейник", -1);
	}

	/**
	 * Проверка повторения строки 0 раз.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRepeatCountZero()
	{
		Stringi.repeat("Муравейник", 0);
	}

	/**
	 * Проверка перемешивания символов в строке.
	 */
	@Test
	public void testShuffle()
	{
		String string = "Когда твоя девушка больна";
		String result = Stringi.shuffle(string);

		assertNotEquals(string, result);
	}

	/**
	 * Проверка перемешивания символов в пустой строке.
	 */
	@Test
	public void testShuffleEmpty()
	{
		String string = "";
		String result = Stringi.shuffle(string);

		assertEquals(string, result);
	}

	/**
	 * Проверка равенства по количеству символов в строке после перемешивания символов в строке.
	 */
	@Test
	public void testShuffleEqualsLength()
	{
		String string = "Когда твоя девушка больна";
		String result = Stringi.shuffle(string);

		assertEquals(string.length(), result.length());
	}

	/**
	 * Проверка переворачивания строки.
	 */
	@Test
	public void testReverse()
	{
		String string = "Малыш";
		String result = Stringi.reverse(string);

		assertEquals("шылаМ", result);
	}

	/**
	 * Проверка переворачивания пустой строки.
	 */
	@Test
	public void testReverseEmpty()
	{
		String string = "";
		String result = Stringi.reverse(string);

		assertEquals("", result);
	}

	/**
	 * Проверка объединения элементов коллекции из {@code String} в строку.
	 */
	@Test
	public void testJoinListString()
	{
		String result = Stringi.join(List.of("Белы", "й д", "ень"));

		assertEquals("Белый день", result);
	}

	/**
	 * Проверка объединения элементов коллекции из {@code String} в строку с разделителем.
	 */
	@Test
	public void testJoinListStringSeparator()
	{
		String result = Stringi.join(List.of("Белы", "й д", "ень"), "|");

		assertEquals("Белы|й д|ень", result);
	}

	/**
	 * Проверка объединения элементов коллекции из {@code String} со значением {@code null} в строку.
	 */
	@Test(expected = NullPointerException.class)
	public void testJoinListStringNull()
	{
		List<String> values = new ArrayList<>();
		values.add("Белы");
		values.add(null);
		values.add("ень");

		Stringi.join(values);
	}

	/**
	 * Проверка объединения пустой коллекции из {@code String} в строку.
	 */
	@Test
	public void testJoinListStringEmpty()
	{
		String result = Stringi.join(List.of());

		assertEquals("", result);
	}

	/**
	 * Проверка объединения элементов массива из {@code String} в строку.
	 */
	@Test
	public void testJoinArrayString()
	{
		String result = Stringi.join(new String[] {"К", "И", "Н", "О"});

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка объединения элементов массива из {@code String} в строку с разделителем.
	 */
	@Test
	public void testJoinArrayStringSeparator()
	{
		String result = Stringi.join(new String[] {"К", "И", "Н", "О"}, "|");

		assertEquals("К|И|Н|О", result);
	}

	/**
	 * Проверка объединения элементов массива из {@code String} со значением {@code null} в строку.
	 */
	@Test(expected = NullPointerException.class)
	public void testJoinArrayStringNull()
	{
		Stringi.join(new String[] {"K", null, "N", "O"});
	}

	/**
	 * Проверка объединения пустого массива из {@code String} в строку.
	 */
	@Test
	public void testJoinArrayStringEmpty()
	{
		String result = Stringi.join(new String[] {});

		assertEquals("", result);
	}
}
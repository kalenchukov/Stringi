/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.stringi;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StringiTest
{
	public static final Character[] CYRILLIC = {
		'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
		'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
		'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
		'ъ', 'ы', 'ь', 'э', 'ю', 'я',

		'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
		'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
		'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
		'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
	};

	public static final Character[] CYRILLIC_LOWER_CASE = {
		'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
		'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
		'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
		'ъ', 'ы', 'ь', 'э', 'ю', 'я'
	};

	public static final Character[] CYRILLIC_UPPER_CASE = {
		'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
		'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
		'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
		'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
	};

	public static final Character[] LATIN = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
		'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
		's', 't', 'u', 'v', 'w', 'x', 'y', 'z',

		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
		'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
		'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};

	public static final Character[] LATIN_LOWER_CASE = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
		'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
		's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
	};

	public static final Character[] LATIN_UPPER_CASE = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
		'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
		'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};

	public static final Character[] SYMBOLS = {
		'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+',
		',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@',
		'[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'
	};

	/**
	 * Проверка принадлежности кириллической буквы к кириллическому алфавиту.
	 */
	@Test
	public void testIsCyrillic1()
	{
		for (char character : CYRILLIC)
		{
			assertTrue(Stringi.isCyrillic(character));
		}
	}

	/**
	 * Проверка принадлежности не кириллической буквы к кириллическому алфавиту.
	 */
	@Test
	public void testIsCyrillic2()
	{
		for (char character : LATIN)
		{
			assertFalse(Stringi.isCyrillic(character));
		}

		for (char character : SYMBOLS)
		{
			assertFalse(Stringi.isCyrillic(character));
		}
	}

	/**
	 * Проверка принадлежности латинской буквы к латинскому алфавиту.
	 */
	@Test
	public void testIsLatin1()
	{
		for (char character : LATIN)
		{
			assertTrue(Stringi.isLatin(character));
		}
	}

	/**
	 * Проверка принадлежности не латинской буквы к латинскому алфавиту.
	 */
	@Test
	public void testIsLatin2()
	{
		for (char character : CYRILLIC)
		{
			assertFalse(Stringi.isLatin(character));
		}

		for (char character : SYMBOLS)
		{
			assertFalse(Stringi.isCyrillic(character));
		}
	}

	/**
	 * Проверка если передана строчная буква.
	 */
	@Test
	public void testIsLowerCase1()
	{
		for (char character : CYRILLIC_LOWER_CASE)
		{
			assertTrue(Stringi.isLowerCase(character));
		}

		for (char character : LATIN_LOWER_CASE)
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
		for (char character : CYRILLIC_UPPER_CASE)
		{
			assertFalse(Stringi.isLowerCase(character));
		}

		for (char character : LATIN_UPPER_CASE)
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
		for (char character : CYRILLIC_UPPER_CASE)
		{
			assertTrue(Stringi.isUpperCase(character));
		}

		for (char character : LATIN_UPPER_CASE)
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
		for (char character : CYRILLIC_LOWER_CASE)
		{
			assertFalse(Stringi.isUpperCase(character));
		}

		for (char character : LATIN_LOWER_CASE)
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
}
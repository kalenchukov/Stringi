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

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link Stringi}.
 *
 * @author Алексей Каленчуков
 */
public class StringiTest
{
	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)}.
	 */
	@Test
	public void firstToLowerCase()
	{
		String actual = Stringi.firstToLowerCase("ПРИВЕТ");

		assertEquals("пРИВЕТ", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} с пустым значением.
	 */
	@Test
	public void firstToLowerCaseEmpty()
	{
		String actual = Stringi.firstToLowerCase("");

		assertEquals("", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} с одной буквой в значении.
	 */
	@Test
	public void firstToLowerCaseOneChar()
	{
		String actual = Stringi.firstToLowerCase("П");

		assertEquals("п", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstToLowerCaseFirstNotChar()
	{
		String actual = Stringi.firstToLowerCase("_ПРИВЕТ");

		assertEquals("_ПРИВЕТ", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)}.
	 */
	@Test
	public void firstToUpperCase()
	{
		String actual = Stringi.firstToUpperCase("привет");

		assertEquals("Привет", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} с пустым значением.
	 */
	@Test
	public void firstToUpperCaseEmpty()
	{
		String actual = Stringi.firstToUpperCase("");

		assertEquals("", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} с одной буквой в значении.
	 */
	@Test
	public void firstToUpperCaseOneChar()
	{
		String actual = Stringi.firstToUpperCase("п");

		assertEquals("П", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstToUpperCaseFirstNotChar()
	{
		String actual = Stringi.firstToUpperCase("_привет");

		assertEquals("_привет", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}.
	 */
	@Test
	public void firstLetterToUpperCase()
	{
		String actual = Stringi.firstLetterToUpperCase("привет");

		assertEquals("Привет", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} с пустым значением.
	 */
	@Test
	public void firstLetterToUpperCaseEmpty()
	{
		String actual = Stringi.firstLetterToUpperCase("");

		assertEquals("", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}с одной буквой в значении.
	 */
	@Test
	public void firstLetterToUpperCaseOneChar()
	{
		String actual = Stringi.firstLetterToUpperCase("п");

		assertEquals("П", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstLetterToUpperCaseFirstNotChar()
	{
		String actual = Stringi.firstLetterToUpperCase("_-привет");

		assertEquals("_-Привет", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если в значении нет букв.
	 */
	@Test
	public void firstLetterToUpperCaseNotChar()
	{
		String actual = Stringi.firstLetterToUpperCase("_-/*-/-/*");

		assertEquals("_-/*-/-/*", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}.
	 */
	@Test
	public void firstLetterToLowerCase()
	{
		String actual = Stringi.firstLetterToLowerCase("ПРИВЕТ");

		assertEquals("пРИВЕТ", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} с пустым значением.
	 */
	@Test
	public void firstLetterToLowerCaseEmpty()
	{
		String actual = Stringi.firstLetterToLowerCase("");

		assertEquals("", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}с одной буквой в значении.
	 */
	@Test
	public void firstLetterToLowerCaseOneChar()
	{
		String actual = Stringi.firstLetterToLowerCase("П");

		assertEquals("п", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstLetterToLowerCaseFirstNotChar()
	{
		String actual = Stringi.firstLetterToLowerCase("_-ПРИВЕТ");

		assertEquals("_-пРИВЕТ", actual);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если в значении нет букв.
	 */
	@Test
	public void firstLetterToLowerCaseNotChar()
	{
		String actual = Stringi.firstLetterToLowerCase("_-/*-/-/*");

		assertEquals("_-/*-/-/*", actual);
	}

	/**
	 * Проверка метода {@link Stringi#reverseCase(String)}.
	 */
	@Test
	public void reverseCase()
	{
		String actual = Stringi.reverseCase("пРиВеТ");

		assertEquals("ПрИвЕт", actual);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, Character)}.
	 */
	@Test
	public void searchFirst()
	{
		Integer actual = Stringi.searchFirst("Красно-жёлтые дни - песня группы Кино", '-');

		assertEquals(6, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, Character)}.
	 */
	@Test
	public void searchLast()
	{
		Integer actual = Stringi.searchLast("Красно-жёлтые дни - песня группы Кино", '-');

		assertEquals(18, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)}.
	 */
	@Test
	public void searchFirstList()
	{
		Integer actual = Stringi.searchFirst(
				"Мама, мы все тяжело больны - песня группы Кино.",
				List.of('.')
		);

		assertEquals(46, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с пустым списком.
	 */
	@Test
	public void searchFirstListEmpty()
	{
		Integer actual = Stringi.searchFirst(
				"Мама, мы все тяжело больны - песня группы Кино.",
				List.of()
		);

		assertNull(actual);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с первым искомым символом в строке.
	 */
	@Test
	public void searchFirstListFirstLetter()
	{
		Integer actual = Stringi.searchFirst(
				"Мама, мы все тяжело больны - песня группы Кино.",
				List.of('М')
		);

		assertEquals(0, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с несколькими искомыми символами.
	 */
	@Test
	public void searchFirstListManyLetter()
	{
		Integer actual = Stringi.searchFirst(
				"Мама, мы все тяжело больны - песня группы Кино.",
				List.of('ж', ',')
		);

		assertEquals(4, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)}.
	 */
	@Test
	public void searchLastList()
	{
		Integer actual = Stringi.searchLast(
				"Мама, мы все тяжело больны - песня группы Кино.",
				List.of('.')
		);

		assertEquals(46, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с пустым списком.
	 */
	@Test
	public void searchLastListEmpty()
	{
		Integer actual = Stringi.searchLast(
				"Мама, мы все тяжело больны - песня группы Кино.",
				List.of()
		);

		assertNull(actual);
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с первым искомым символом в строке.
	 */
	@Test
	public void searchLastListFirstLetter()
	{
		Integer actual = Stringi.searchLast(
				"Мама, мы все тяжело больны - песня группы Кино.",
				List.of('М')
		);

		assertEquals(0, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с несколькими искомыми символами.
	 */
	@Test
	public void searchLastListManyLetter()
	{
		Integer actual = Stringi.searchLast(
				"Мама, мы все тяжело больны - песня группы Кино.",
				List.of('ж', ',')
		);

		assertEquals(15, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirstLetter(String)}.
	 */
	@Test
	public void searchFirstLetter()
	{
		Integer actual = Stringi.searchFirstLetter("+Когда твоя девушка больна+");

		assertEquals(1, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLastLetter(String)}.
	 */
	@Test
	public void searchLastLetter()
	{
		Integer actual = Stringi.searchLastLetter("###Ночь###");

		assertEquals(6, Optional.ofNullable(actual).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)}.
	 */
	@Test
	public void repeatToLength()
	{
		String actual = Stringi.repeatToLength("Без десяти", 15);

		assertEquals("Без десятиБез д", actual);
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)} с отрицательным значением.
	 */
	@Test
	public void repeatToLengthLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.repeatToLength("Без десяти", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)} с нулевым значением.
	 */
	@Test
	public void repeatToLengthLengthZero()
	{
		String actual = Stringi.repeatToLength("Без десяти", 0);

		assertEquals("", actual);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)}.
	 */
	@Test
	public void shuffle()
	{
		String value = "Когда твоя девушка больна";

		String actual = Stringi.shuffle(value);

		assertNotEquals("Когда твоя девушка больна", actual);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)} с пустым значением.
	 */
	@Test
	public void shuffleEmpty()
	{
		String value = "";
		String actual = Stringi.shuffle(value);

		assertEquals("", actual);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)} по количеству символов в строке
	 * после перемешивания символов в строке.
	 */
	@Test
	public void shuffleEqualsLength()
	{
		String value = "Когда твоя девушка больна";
		String actual = Stringi.shuffle(value);

		assertEquals("Когда твоя девушка больна".length(), actual.length());
	}

	/**
	 * Проверка метода {@link Stringi#reverse(String)}.
	 */
	@Test
	public void reverse()
	{
		String value = "Малыш";
		String actual = Stringi.reverse(value);

		assertEquals("шылаМ", actual);
	}

	/**
	 * Проверка метода {@link Stringi#reverse(String)} с пустым значением.
	 */
	@Test
	public void reverseEmpty()
	{
		String value = "";
		String actual = Stringi.reverse(value);

		assertEquals("", actual);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
	 */
	@Test
	public void countVariousSymbolsEmpty()
	{
		String value = "";
		Integer actual = Stringi.countVariousSymbols(value);

		assertEquals(0, actual);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
	 */
	@Test
	public void countVariousSymbols()
	{
		String value = "Я хочу быть кочегаром";
		Integer actual = Stringi.countVariousSymbols(value);

		assertEquals(16, actual);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с переносом строки.
	 */
	@Test
	public void countVariousSymbolsReturnLine()
	{
		String value = "Я хочу быть кочегаром\n";
		Integer actual = Stringi.countVariousSymbols(value);

		assertEquals(17, actual);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindrome(String)}.
	 */
	@Test
	public void isPalindrome()
	{
		boolean actual = Stringi.isPalindrome("ШАЛАШ");

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindrome(String)} с некорректным значением.
	 */
	@Test
	public void isPalindromeNotCorrect()
	{
		boolean actual = Stringi.isPalindrome("МАЛЫШ");

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)}.
	 */
	@Test
	public void isPalindromeIgnoreCase()
	{
		boolean actual = Stringi.isPalindromeIgnoreCase("Шалаш");

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)} с некорректным значением.
	 */
	@Test
	public void isPalindromeIgnoreCaseNotCorrect()
	{
		boolean actual = Stringi.isPalindromeIgnoreCase("Малыш");

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Stringi#join(List)}.
	 */
	@Test
	public void joinList()
	{
		String actual = Stringi.join(List.of("Белы", "й д", "ень"));

		assertEquals("Белый день", actual);
	}

	/**
	 * Проверка метода {@link Stringi#join(List, String)}.
	 */
	@Test
	public void joinListSeparator()
	{
		String actual = Stringi.join(List.of("Белы", "й д", "ень"), "|");

		assertEquals("Белы|й д|ень", actual);
	}

	/**
	 * Проверка метода {@link Stringi#join(List)} со значением {@code null}.
	 */
	@Test
	public void joinListNull()
	{
		List<String> values = new ArrayList<>();
		values.add("Белый");
		values.add(null);
		values.add("день");

		String actual = Stringi.join(values);

		assertEquals("Белыйдень", actual);
	}

	/**
	 * Проверка метода {@link Stringi#join(List)} без значений.
	 */
	@Test
	public void joinListEmpty()
	{
		String actual = Stringi.join(List.of());

		assertEquals("", actual);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])}.
	 */
	@Test
	public void joinArray()
	{
		String actual = Stringi.join(new String[] {"К", "И", "Н", "О"});

		assertEquals("КИНО", actual);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[], String)}.
	 */
	@Test
	public void joinArraySeparator()
	{
		String actual = Stringi.join(new String[] {"К", "И", "Н", "О"}, "|");

		assertEquals("К|И|Н|О", actual);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])} со значением {@code null}.
	 */
	@Test
	public void joinArrayNull()
	{
		String actual = Stringi.join(new String[] {"K", "I", null, "N", "O"});

		assertEquals("KINO", actual);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])} без значений.
	 */
	@Test
	public void joinArrayEmpty()
	{
		String actual = Stringi.join(new String[] {});

		assertEquals("", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)}.
	 */
	@Test
	public void fillLeft()
	{
		String actual = Stringi.fillLeft("КИНО", "#", 10);

		assertEquals("######КИНО", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с нулевым значением.
	 */
	@Test
	public void fillLeftLengthZero()
	{
		String actual = Stringi.fillLeft("КИНО", "#", 0);

		assertEquals("КИНО", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillLeftFillerEmpty()
	{
		String actual = Stringi.fillLeft("КИНО", "", 10);

		assertEquals("КИНО", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillLeftStringEmpty()
	{
		String actual = Stringi.fillLeft("", "#", 10);

		assertEquals("##########", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void fillLeftLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fillLeft("КИНО", "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)}.
	 */
	@Test
	public void fill()
	{
		String actual = Stringi.fill("КИНО", "#", 10);

		assertEquals("###КИНО###", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} нулевым значением.
	 */
	@Test
	public void fillLengthZero()
	{
		String actual = Stringi.fill("КИНО", "#", 0);

		assertEquals("КИНО", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillFillerEmpty()
	{
		String actual = Stringi.fill("КИНО", "", 10);

		assertEquals("КИНО", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillStringEmpty()
	{
		String actual = Stringi.fill("", "#", 10);

		assertEquals("##########", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void fillLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fill("КИНО", "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с нечётным значением.
	 */
	@Test
	public void fillLengthUneven()
	{
		String actual = Stringi.fill("КИНО", "#", 9);

		assertEquals("##КИНО###", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)}.
	 */
	@Test
	public void fillRight()
	{
		String actual = Stringi.fillRight("КИНО", "#", 10);

		assertEquals("КИНО######", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с нулевым значением.
	 */
	@Test
	public void fillRightLengthZero()
	{
		String actual = Stringi.fillRight("КИНО", "#", 0);

		assertEquals("КИНО", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillRightFillerEmpty()
	{
		String actual = Stringi.fillRight("КИНО", "", 10);

		assertEquals("КИНО", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillRightStringEmpty()
	{
		String actual = Stringi.fillRight("", "#", 10);

		assertEquals("##########", actual);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void fillRightLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fillRight("КИНО", "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#toCharList(String)}.
	 */
	@Test
	public void toCharList()
	{
		List<Character> expected = List.of(
			'W', 'a', 'l', 'k', ' ', 'a', 'l', 'l', ' ', 'o', 'v', 'e', 'r', ' ', 'y', 'o', 'u'
		);

		List<Character> actual = Stringi.toCharList("Walk all over you");

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Stringi#toCharList(String)}.
	 */
	@Test
	public void toCharListEmpty()
	{
		List<Character> expected = List.of();

		List<Character> actual = Stringi.toCharList("");

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Stringi#toCharArray(String)}.
	 */
	@Test
	public void toCharArray()
	{
		Character[] expected = {
			'W', 'a', 'l', 'k', ' ', 'a', 'l', 'l', ' ', 'o', 'v', 'e', 'r', ' ', 'y', 'o', 'u'
		};

		Character[] actual = Stringi.toCharArray("Walk all over you");

		assertArrayEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Stringi#toCharArray(String)} с пустым значением.
	 */
	@Test
	public void toCharArrayEmpty()
	{
		Character[] expected = {};

		Character[] actual = Stringi.toCharArray("");

		assertArrayEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List)}.
	 */
	@Test
	public void glueList()
	{
		String actual = Stringi.glue(List.of('A', 'C', '/', 'D', 'C'));

		assertEquals("AC/DC", actual);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List, String)}.
	 */
	@Test
	public void glueListSeparator()
	{
		String actual = Stringi.glue(List.of('T', 'N', 'T'), ".");

		assertEquals("T.N.T", actual);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List)} со значением {@code null}.
	 */
	@Test
	public void glueListNull()
	{
		List<Character> values = new ArrayList<>();
		values.add('A');
		values.add('C');
		values.add(null);
		values.add('D');
		values.add('C');

		String actual = Stringi.glue(values);

		assertEquals("ACDC", actual);
	}
	
	/**
	 * Проверка метода {@link Stringi#glue(List)} без значений.
	 */
	@Test
	public void glueListEmpty()
	{
		String actual = Stringi.glue(List.of());

		assertEquals("", actual);
	}
	
	/**
	 * Проверка метода {@link Stringi#glue(Character[])}.
	 */
	@Test
	public void glueArray()
	{
		String actual = Stringi.glue(new Character[] {'A', 'C', '/', 'D', 'C'});

		assertEquals("AC/DC", actual);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[], String)}.
	 */
	@Test
	public void glueArraySeparator()
	{
		String actual = Stringi.glue(new Character[] {'T', 'N', 'T'}, ".");

		assertEquals("T.N.T", actual);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[])} со значением {@code null}.
	 */
	@Test
	public void glueArrayNull()
	{
		String actual = Stringi.glue(new Character[] {'T', null, 'N', 'T'});

		assertEquals("TNT", actual);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[])} без значений.
	 */
	@Test
	public void glueArrayEmpty()
	{
		String actual = Stringi.glue(new Character[] {});

		assertEquals("", actual);
	}
}
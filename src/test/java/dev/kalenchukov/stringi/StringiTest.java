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
		String value = "ПРИВЕТ";

		String actualString = Stringi.firstToLowerCase(value);

		assertEquals("пРИВЕТ", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} с пустым значением.
	 */
	@Test
	public void firstToLowerCaseEmpty()
	{
		String value = "";

		String actualString = Stringi.firstToLowerCase(value);

		assertEquals("", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} с одной буквой в значении.
	 */
	@Test
	public void firstToLowerCaseOneChar()
	{
		String value = "П";

		String actualString = Stringi.firstToLowerCase(value);

		assertEquals("п", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstToLowerCaseFirstNotChar()
	{
		String value = "_ПРИВЕТ";

		String actualString = Stringi.firstToLowerCase(value);

		assertEquals("_ПРИВЕТ", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)}.
	 */
	@Test
	public void firstToUpperCase()
	{
		String value = "привет";

		String actualString = Stringi.firstToUpperCase(value);

		assertEquals("Привет", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} с пустым значением.
	 */
	@Test
	public void firstToUpperCaseEmpty()
	{
		String value = "";

		String actualString = Stringi.firstToUpperCase(value);

		assertEquals("", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} с одной буквой в значении.
	 */
	@Test
	public void firstToUpperCaseOneChar()
	{
		String value = "п";

		String actualString = Stringi.firstToUpperCase(value);

		assertEquals("П", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstToUpperCaseFirstNotChar()
	{
		String value = "_привет";

		String actualString = Stringi.firstToUpperCase(value);

		assertEquals("_привет", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}.
	 */
	@Test
	public void firstLetterToUpperCase()
	{
		String value = "привет";

		String actualString = Stringi.firstLetterToUpperCase(value);

		assertEquals("Привет", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} с пустым значением.
	 */
	@Test
	public void firstLetterToUpperCaseEmpty()
	{
		String value = "";

		String actualString = Stringi.firstLetterToUpperCase(value);

		assertEquals("", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}с одной буквой в значении.
	 */
	@Test
	public void firstLetterToUpperCaseOneChar()
	{
		String value = "п";

		String actualString = Stringi.firstLetterToUpperCase(value);

		assertEquals("П", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstLetterToUpperCaseFirstNotChar()
	{
		String value = "_-привет";

		String actualString = Stringi.firstLetterToUpperCase(value);

		assertEquals("_-Привет", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если в значении нет букв.
	 */
	@Test
	public void firstLetterToUpperCaseNotChar()
	{
		String value = "_-/*-/-/*";

		String actualString = Stringi.firstLetterToUpperCase(value);

		assertEquals("_-/*-/-/*", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}.
	 */
	@Test
	public void firstLetterToLowerCase()
	{
		String value = "ПРИВЕТ";

		String actualString = Stringi.firstLetterToLowerCase(value);

		assertEquals("пРИВЕТ", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} с пустым значением.
	 */
	@Test
	public void firstLetterToLowerCaseEmpty()
	{
		String value = "";

		String actualString = Stringi.firstLetterToLowerCase(value);

		assertEquals("", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}с одной буквой в значении.
	 */
	@Test
	public void firstLetterToLowerCaseOneChar()
	{
		String value = "П";

		String actualString = Stringi.firstLetterToLowerCase(value);

		assertEquals("п", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstLetterToLowerCaseFirstNotChar()
	{
		String value = "_-ПРИВЕТ";

		String actualString = Stringi.firstLetterToLowerCase(value);

		assertEquals("_-пРИВЕТ", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если в значении нет букв.
	 */
	@Test
	public void firstLetterToLowerCaseNotChar()
	{
		String value = "_-/*-/-/*";

		String actualString = Stringi.firstLetterToLowerCase(value);

		assertEquals("_-/*-/-/*", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#reverseCase(String)}.
	 */
	@Test
	public void reverseCase()
	{
		String value = "пРиВеТ";

		String actualString = Stringi.reverseCase(value);

		assertEquals("ПрИвЕт", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, Character)}.
	 */
	@Test
	public void searchFirst()
	{
		String value = "Красно-жёлтые дни - песня группы Кино";

		Integer actualPosition = Stringi.searchFirst(value, '-');

		assertEquals(6, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, Character)}.
	 */
	@Test
	public void searchLast()
	{
		String value = "Красно-жёлтые дни - песня группы Кино";

		Integer actualPosition = Stringi.searchLast(value, '-');

		assertEquals(18, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)}.
	 */
	@Test
	public void searchFirstList()
	{
		String value = "Мама, мы все тяжело больны - песня группы Кино.";

		Integer actualPosition = Stringi.searchFirst(value, List.of('.'));

		assertEquals(46, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с пустым списком.
	 */
	@Test
	public void searchFirstListEmpty()
	{
		String value = "Мама, мы все тяжело больны - песня группы Кино.";

		Integer actualPosition = Stringi.searchFirst(value, List.of());

		assertNull(actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с первым искомым символом в строке.
	 */
	@Test
	public void searchFirstListFirstLetter()
	{
		String value = "Мама, мы все тяжело больны - песня группы Кино.";

		Integer actualPosition = Stringi.searchFirst(value, List.of('М'));

		assertEquals(0, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с несколькими искомыми символами.
	 */
	@Test
	public void searchFirstListManyLetter()
	{
		String value = "Мама, мы все тяжело больны - песня группы Кино.";

		Integer actualPosition = Stringi.searchFirst(value, List.of('ж', ','));

		assertEquals(4, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)}.
	 */
	@Test
	public void searchLastList()
	{
		String value = "Мама, мы все тяжело больны - песня группы Кино.";

		Integer actualPosition = Stringi.searchLast(value, List.of('.'));

		assertEquals(46, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с пустым списком.
	 */
	@Test
	public void searchLastListEmpty()
	{
		String value = "Мама, мы все тяжело больны - песня группы Кино.";

		Integer actualPosition = Stringi.searchLast(value, List.of());

		assertNull(actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с первым искомым символом в строке.
	 */
	@Test
	public void searchLastListFirstLetter()
	{
		String value = "Мама, мы все тяжело больны - песня группы Кино.";

		Integer actualPosition = Stringi.searchLast(value, List.of('М'));

		assertEquals(0, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с несколькими искомыми символами.
	 */
	@Test
	public void searchLastListManyLetter()
	{
		String value = "Мама, мы все тяжело больны - песня группы Кино.";

		Integer actualPosition = Stringi.searchLast(value, List.of('ж', ','));

		assertEquals(15, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirstLetter(String)}.
	 */
	@Test
	public void searchFirstLetter()
	{
		String value = "+Когда твоя девушка больна+";

		Integer actualPosition = Stringi.searchFirstLetter(value);

		assertEquals(1, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#searchLastLetter(String)}.
	 */
	@Test
	public void searchLastLetter()
	{
		String value = "###Ночь###";

		Integer actualPosition = Stringi.searchLastLetter(value);

		assertEquals(6, actualPosition);
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)}.
	 */
	@Test
	public void repeatToLength()
	{
		String value = "Без десяти";

		String actualString = Stringi.repeatToLength(value, 15);

		assertEquals("Без десятиБез д", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)} с отрицательным значением.
	 */
	@Test
	public void repeatToLengthLengthNegative()
	{
		String value = "Без десяти";

		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.repeatToLength(value, -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)} с нулевым значением.
	 */
	@Test
	public void repeatToLengthLengthZero()
	{
		String value = "Без десяти";

		String actualString = Stringi.repeatToLength(value, 0);

		assertEquals("", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)}.
	 */
	@Test
	public void shuffle()
	{
		String value = "Когда твоя девушка больна";

		String actualString = Stringi.shuffle(value);

		assertNotEquals("Когда твоя девушка больна", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)} с пустым значением.
	 */
	@Test
	public void shuffleEmpty()
	{
		String value = "";

		String actualString = Stringi.shuffle(value);

		assertEquals("", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)} по количеству символов в строке
	 * после перемешивания символов в строке.
	 */
	@Test
	public void shuffleEqualsLength()
	{
		String value = "Когда твоя девушка больна";

		String actualString = Stringi.shuffle(value);

		assertEquals("Когда твоя девушка больна".length(), actualString.length());
	}

	/**
	 * Проверка метода {@link Stringi#reverse(String)}.
	 */
	@Test
	public void reverse()
	{
		String value = "Малыш";

		String actualString = Stringi.reverse(value);

		assertEquals("шылаМ", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#reverse(String)} с пустым значением.
	 */
	@Test
	public void reverseEmpty()
	{
		String value = "";

		String actualString = Stringi.reverse(value);

		assertEquals("", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
	 */
	@Test
	public void countVariousSymbolsEmpty()
	{
		String value = "";

		Integer actualCount = Stringi.countVariousSymbols(value);

		assertEquals(0, actualCount);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
	 */
	@Test
	public void countVariousSymbols()
	{
		String value = "Я хочу быть кочегаром";

		Integer actualCount = Stringi.countVariousSymbols(value);

		assertEquals(16, actualCount);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с переносом строки.
	 */
	@Test
	public void countVariousSymbolsReturnLine()
	{
		String value = "Я хочу быть кочегаром\n";

		Integer actualCount = Stringi.countVariousSymbols(value);

		assertEquals(17, actualCount);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindrome(String)}.
	 */
	@Test
	public void isPalindrome()
	{
		String value = "ШАЛАШ";

		boolean actual = Stringi.isPalindrome(value);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindrome(String)} с некорректным значением.
	 */
	@Test
	public void isPalindromeNotCorrect()
	{
		String value = "МАЛЫШ";

		boolean actual = Stringi.isPalindrome(value);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)}.
	 */
	@Test
	public void isPalindromeIgnoreCase()
	{
		String value = "Шалаш";

		boolean actual = Stringi.isPalindromeIgnoreCase(value);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)} с некорректным значением.
	 */
	@Test
	public void isPalindromeIgnoreCaseNotCorrect()
	{
		String value = "Малыш";

		boolean actual = Stringi.isPalindromeIgnoreCase(value);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Stringi#join(List)}.
	 */
	@Test
	public void joinList()
	{
		List<String> value = List.of("Белы", "й д", "ень");

		String actualString = Stringi.join(value);

		assertEquals("Белый день", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#join(List, String)}.
	 */
	@Test
	public void joinListSeparator()
	{
		List<String> value = List.of("Белы", "й д", "ень");

		String actualString = Stringi.join(value, "|");

		assertEquals("Белы|й д|ень", actualString);
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

		String actualString = Stringi.join(values);

		assertEquals("Белыйдень", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#join(List)} без значений.
	 */
	@Test
	public void joinListEmpty()
	{
		List<String> value = List.of();

		String actualString = Stringi.join(value);

		assertEquals("", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])}.
	 */
	@Test
	public void joinArray()
	{
		String[] value = new String[] {"К", "И", "Н", "О"};

		String actualString = Stringi.join(value);

		assertEquals("КИНО", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[], String)}.
	 */
	@Test
	public void joinArraySeparator()
	{
		String[] value = new String[] {"К", "И", "Н", "О"};

		String actualString = Stringi.join(value, "|");

		assertEquals("К|И|Н|О", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])} со значением {@code null}.
	 */
	@Test
	public void joinArrayNull()
	{
		String[] value = new String[] {"K", "I", null, "N", "O"};

		String actualString = Stringi.join(value);

		assertEquals("KINO", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])} без значений.
	 */
	@Test
	public void joinArrayEmpty()
	{
		String[] value = new String[] {};

		String actualString = Stringi.join(value);

		assertEquals("", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)}.
	 */
	@Test
	public void fillLeft()
	{
		String value = "КИНО";

		String actualString = Stringi.fillLeft(value, "#", 10);

		assertEquals("######КИНО", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с нулевым значением.
	 */
	@Test
	public void fillLeftLengthZero()
	{
		String value = "КИНО";

		String actualString = Stringi.fillLeft(value, "#", 0);

		assertEquals("КИНО", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillLeftFillerEmpty()
	{
		String value = "КИНО";

		String actualString = Stringi.fillLeft(value, "", 10);

		assertEquals("КИНО", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillLeftStringEmpty()
	{
		String value = "";

		String actualString = Stringi.fillLeft(value, "#", 10);

		assertEquals("##########", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void fillLeftLengthNegative()
	{
		String value = "КИНО";

		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fillLeft(value, "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)}.
	 */
	@Test
	public void fill()
	{
		String value = "КИНО";

		String actualString = Stringi.fill(value, "#", 10);

		assertEquals("###КИНО###", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} нулевым значением.
	 */
	@Test
	public void fillLengthZero()
	{
		String value = "КИНО";

		String actualString = Stringi.fill(value, "#", 0);

		assertEquals("КИНО", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillFillerEmpty()
	{
		String value = "КИНО";

		String actualString = Stringi.fill(value, "", 10);

		assertEquals("КИНО", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillStringEmpty()
	{
		String value = "";

		String actualString = Stringi.fill(value, "#", 10);

		assertEquals("##########", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void fillLengthNegative()
	{
		String value = "КИНО";

		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fill(value, "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с нечётным значением.
	 */
	@Test
	public void fillLengthUneven()
	{
		String value = "КИНО";

		String actualString = Stringi.fill(value, "#", 9);

		assertEquals("##КИНО###", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)}.
	 */
	@Test
	public void fillRight()
	{
		String value = "КИНО";

		String actualString = Stringi.fillRight(value, "#", 10);

		assertEquals("КИНО######", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с нулевым значением.
	 */
	@Test
	public void fillRightLengthZero()
	{
		String value = "КИНО";

		String actualString = Stringi.fillRight(value, "#", 0);

		assertEquals("КИНО", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillRightFillerEmpty()
	{
		String value = "КИНО";

		String actualString = Stringi.fillRight(value, "", 10);

		assertEquals("КИНО", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillRightStringEmpty()
	{
		String value = "";

		String actualString = Stringi.fillRight(value, "#", 10);

		assertEquals("##########", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void fillRightLengthNegative()
	{
		String value = "КИНО";

		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fillRight(value, "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#toCharList(String)}.
	 */
	@Test
	public void toCharList()
	{
		String value = "Walk all over you";
		List<Character> expectedList = List.of(
			'W', 'a', 'l', 'k', ' ', 'a', 'l', 'l', ' ', 'o', 'v', 'e', 'r', ' ', 'y', 'o', 'u'
		);

		List<Character> actualList = Stringi.toCharList(value);

		assertEquals(expectedList, actualList);
	}

	/**
	 * Проверка метода {@link Stringi#toCharList(String)}.
	 */
	@Test
	public void toCharListEmpty()
	{
		String value = "";
		List<Character> expectedList = List.of();

		List<Character> actualList = Stringi.toCharList(value);

		assertEquals(expectedList, actualList);
	}

	/**
	 * Проверка метода {@link Stringi#toCharArray(String)}.
	 */
	@Test
	public void toCharArray()
	{
		String value = "Walk all over you";
		Character[] expectedArray = {
			'W', 'a', 'l', 'k', ' ', 'a', 'l', 'l', ' ', 'o', 'v', 'e', 'r', ' ', 'y', 'o', 'u'
		};

		Character[] actualArray = Stringi.toCharArray(value);

		assertArrayEquals(expectedArray, actualArray);
	}

	/**
	 * Проверка метода {@link Stringi#toCharArray(String)} с пустым значением.
	 */
	@Test
	public void toCharArrayEmpty()
	{
		String value = "";
		Character[] expectedArray = {};

		Character[] actualArray = Stringi.toCharArray(value);

		assertArrayEquals(expectedArray, actualArray);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List)}.
	 */
	@Test
	public void glueList()
	{
		List<Character> value = List.of('A', 'C', '/', 'D', 'C');

		String actualString = Stringi.glue(value);

		assertEquals("AC/DC", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List, String)}.
	 */
	@Test
	public void glueListSeparator()
	{
		List<Character> value = List.of('T', 'N', 'T');

		String actualString = Stringi.glue(value, ".");

		assertEquals("T.N.T", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List)} со значением {@code null}.
	 */
	@Test
	public void glueListNull()
	{
		List<Character> value = new ArrayList<>();
		value.add('A');
		value.add('C');
		value.add(null);
		value.add('D');
		value.add('C');

		String actualString = Stringi.glue(value);

		assertEquals("ACDC", actualString);
	}
	
	/**
	 * Проверка метода {@link Stringi#glue(List)} без значений.
	 */
	@Test
	public void glueListEmpty()
	{
		List<Character> value = List.of();

		String actualString = Stringi.glue(value);

		assertEquals("", actualString);
	}
	
	/**
	 * Проверка метода {@link Stringi#glue(Character[])}.
	 */
	@Test
	public void glueArray()
	{
		Character[] value = new Character[] {'A', 'C', '/', 'D', 'C'};

		String actualString = Stringi.glue(value);

		assertEquals("AC/DC", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[], String)}.
	 */
	@Test
	public void glueArraySeparator()
	{
		Character[] value = new Character[] {'T', 'N', 'T'};

		String actualString = Stringi.glue(value, ".");

		assertEquals("T.N.T", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[])} со значением {@code null}.
	 */
	@Test
	public void glueArrayNull()
	{
		Character[] value = new Character[] {'T', null, 'N', 'T'};

		String actualString = Stringi.glue(value);

		assertEquals("TNT", actualString);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[])} без значений.
	 */
	@Test
	public void glueArrayEmpty()
	{
		Character[] value = new Character[] {};

		String actualString = Stringi.glue(value);

		assertEquals("", actualString);
	}
}
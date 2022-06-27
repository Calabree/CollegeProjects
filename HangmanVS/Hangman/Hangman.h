#pragma once
#include <iostream>
using namespace std;

class Hangman
{
private:
	int* numOfLetters, hangman, counter;
	char* guessWord, * theGuess, guessedLetter;
	bool win, endGame, correctGuess;
public:
	Hangman(int, char[]);
	~Hangman();
	int getHangman() { return hangman; }
	bool getWin() { return win; }
	Hangman& guessALetter(char);
	Hangman& gameResults();
	void winClause(bool&);
	void blankDisplay();
};

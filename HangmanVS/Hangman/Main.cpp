#include <iostream>
#include <stdio.h>
#include <conio.h>
#include "Hangman.h"

using namespace std;

int main() {
	int letterCount;
	char theWord[30];
	char guess = NULL;
	bool WIN = false;

	cout << "*-------------------*\n\n"
		<< "      HANGMAN\n"
		<< "\n*------------------*" << endl;
	cout << "Please let Player 1 provide information on the word.\nOnce Player 1 provides the word information, He/She may pass it back to player 2 so they may guess!" << endl << endl;
	cout << "Please think of a word that is 30 characters long or less!" << endl << endl;

	cout << "Player 1, how many characters are in your word?: ";
	cin >> letterCount;
	cout << "What is the word?" << endl;
	cin >> theWord;
	system("CLS");

	Hangman userWord(letterCount, theWord);
	bool game = false;

	while (userWord.getHangman() < 6 && guess != '1' && game == false)
	{	// clears the refreshes the console so the word legnth stays on the screen with the hangman printout the whole time
		system("CLS");
		userWord.gameResults();
		userWord.blankDisplay();
		// loops the user guess input
		if (userWord.getHangman() < 6 && guess != '1' && game == false) {
			cout << "\nGuess a letter (or enter '1' to quit)" << endl;
			cin >> guess;
			userWord.guessALetter(guess).winClause(game);
		}
	}
	// clears screen again, displays either the win or loss prompt
	system("CLS");
	userWord.gameResults();
	cout << "Your guess: ";
	userWord.blankDisplay();
	cout << "\nThe word: " << theWord << endl;
	userWord.~Hangman();
	cout << "Thank you for playing.\nPlease press any key to Exit" << endl;
	_getch();
	return 0;
}

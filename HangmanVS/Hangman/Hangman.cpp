#include "Hangman.h"
#include <iostream>

Hangman::Hangman(int letters, char word[]) {
	numOfLetters = new int;
	*numOfLetters = letters;
	guessWord = new char[*numOfLetters];
	for (int x = 0; x < (*numOfLetters); x++) {
		guessWord[x] = word[x];
	}
	theGuess = new char[(*numOfLetters)];
	cout << "Welcome Player Two. Here is the blank word Player One has provided. Good Luck!\n";
	for (int x = 0; x < (*numOfLetters); x++) {
		theGuess[x] = '*';
		cout << theGuess[x];
	}
	cout << endl;
	counter = 0;
	hangman = 0;
}

Hangman::~Hangman() {

	//destructor threw fatial error when ran unless pointers were initialized as null before deleting
	numOfLetters = nullptr;
	delete numOfLetters;
	guessWord = nullptr;
	delete[] guessWord;
	theGuess = nullptr;
	delete[] theGuess;
}

Hangman& Hangman::guessALetter(char userGuess) {
	guessedLetter = userGuess;
	correctGuess = false;
	while (win == false) {
		counter++;
		for (int x = 0; x < *numOfLetters; x++) {
			if (guessWord[x] == userGuess) {
				theGuess[x] = userGuess;
				correctGuess = true;
			}
		}
		if (correctGuess == false) {
			cout << "Hmmm. Doesn't look like that letter is part of the word." << endl;
			hangman++;
		}
		break;
	}
	return *this;
}

Hangman& Hangman::gameResults() {
	//draws hangman/checks for quit and/or win/34
	if (hangman < 1) {
		cout << endl << endl
			<< "   +----+  " << endl
			<< "   |    |  " << endl
			<< "   |       " << endl
			<< "   |       " << endl
			<< "   |       " << endl
			<< "   |       " << endl
			<< "  =============" << endl << endl;
	}
	if (hangman == 1) {
		cout << endl << endl
			<< "   +----+  " << endl
			<< "   |    |  " << endl
			<< "   |    O  " << endl
			<< "   |       " << endl
			<< "   |       " << endl
			<< "   |       " << endl
			<< "  =============" << endl << endl;
	}
	else if (hangman == 2) {
		cout << endl << endl
			<< "   +----+  " << endl
			<< "   |    |  " << endl
			<< "   |    O  " << endl
			<< "   |    |  " << endl
			<< "   |       " << endl
			<< "   |       " << endl
			<< "  =============" << endl << endl;
	}
	else if (hangman == 3) {
		cout << endl << endl
			<< "   +----+  " << endl
			<< "   |    |  " << endl
			<< "   |    O  " << endl
			<< "   |   /|  " << endl
			<< "   |       " << endl
			<< "   |       " << endl
			<< "  =============" << endl << endl;
	}
	else if (hangman == 4) {
		cout << endl << endl
			<< "   +----+  " << endl
			<< "   |    |  " << endl
			<< "   |    O  " << endl
			<< "   |   /|\\ " << endl
			<< "   |       " << endl
			<< "   |       " << endl
			<< "  =============" << endl << endl;
	}
	else if (hangman == 5) {
		cout << endl << endl
			<< "   +----+  " << endl
			<< "   |    |  " << endl
			<< "   |    O  " << endl
			<< "   |   /|\\ " << endl
			<< "   |     \\ " << endl
			<< "   |       " << endl
			<< "  ============" << endl << endl;
	}
	else if (hangman == 6) {
		cout << endl << endl
			<< "   +----+     " << endl
			<< "   |    |     " << endl
			<< "   |    O     " << endl
			<< "   |   /|\\   " << endl
			<< "   |   / \\   " << endl
			<< "   |You're Dead " << endl
			<< "  ============" << endl << endl;
	}
	// if user presses 1 game ends and prints out the following
	if (guessedLetter == '1')
	{
		cout << "It's a shame you chose to quit. Thanks for playing" << endl;
	}

	if (endGame == true && hangman != 6) {
		cout << "\nYou won! Good Job!!" << endl;
		endGame = true;
	}

	if (hangman == 6) {
		cin.get();
		cout << "\nYou lost! The game is over, try again!" << endl;
		endGame = true;
	}

	return *this;
}

void Hangman::winClause(bool& gameOver) {
	// checks to see if the word the user is guessing is complete, if player 1's word is not the same as players 2 guess, game does not end.
	char cont;
	gameOver = true;
	endGame = true;
	for (int x = 0; x < (*numOfLetters); x++) {
		if (guessWord[x] != theGuess[x]) {
			endGame = false;
			gameOver = false;
		}
	}

}

void Hangman::blankDisplay() {
	// displays the users word as it is guessed used to keep the users word underneath hangman at all times
	for (int x = 0; x < *numOfLetters; x++) {
		cout << theGuess[x];
	}
}
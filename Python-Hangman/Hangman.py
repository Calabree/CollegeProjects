from os import system, name
def newWord(word, wordToGuess, blankWordToGuess):
    wordToGuess=list(word)
    for x in wordToGuess:
        blankWordToGuess.append('_')

def wordChecker(userGuess, wordToGuess, blankToGuess):
    x=0
    global guessesLeft
    letterGuessedCorrectly=False
    for i in word:
        if i == userGuess:
            print('found')
            blankToGuess[x] = userGuess
            letterGuessedCorrectly=True
        x+=1
    if letterGuessedCorrectly == False:
        print(f'Looks like your guess {userGuess} was wrong')
        guessesLeft = guessesLeft-1
        print(f'You have {guessesLeft} guesses left! Choose carefully!')

def theMan(guessesLeft):

    switch={
        6:'''
        +---+
        |   |
            |
            |
            |
            |
        =========''',
        5: '''
        +---+
        |   |
        O   |
            |
            |
            |
        ======== ''', 
        4: '''
        +---+
        |   |
        O   |
        |   |
            |
            |
        ======== ''',
        3: '''
        +---+
        |   |
        O   |
       /|   |
            |
            |
        ======== ''',
        2: '''
        +---+
        |   |
        O   |
       /|\  |
            |
            |
        ======== ''',
        1: '''
        +---+
        |   |
        O   |
       /|\  |
       /    |
            |
        ======== ''', 
        0: '''
        +---+
        |   |
        O   |
       /|\  |
       / \  |
            |
        ======== '''
    }
    return switch.get(guessesLeft)

def clear(): 
  
    if name == 'nt':
        _ = system('cls') 
    else: 
        _ = system('clear') 

def gameOver():
    
    global guessesLeft, word, gameOn
    if guessesLeft == 0:
        print ("Game Over!")
        gameOn = False
    if list(word) == blankToGuess:
        print ("you won!")
        gameOn = False
    
        
clear()
gameOn = True
guessesLeft=6
word = input ("Provide a word: ").lower()
clear()
wordToGuess= []
blankToGuess=[]
newWord(word, wordToGuess, blankToGuess)

while (gameOn ==  True):

    userGuess = input('Guess a letter: ')
    wordChecker(userGuess, wordToGuess, blankToGuess)
    print(*blankToGuess)
    print(theMan(guessesLeft))
    gameOver()
    wait=input("Press enter to continue")
    clear()

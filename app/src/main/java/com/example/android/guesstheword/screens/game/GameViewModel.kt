package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel : ViewModel() {

    /*// The current word
    var word = ""

    // The current score
    var score = 0*/

/*    // The current word
    val word = MutableLiveData<String>()
    // The current score
    val score = MutableLiveData<Int>()*/

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>


    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    init {
        /*word.value = ""*/
        _word.value = ""
        /*score.value = 0*/
        _score.value = 0
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    /**
     * Callback called when the ViewModel is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /** Methods for updating the UI **/
    fun onSkip() {
        /*score.value = (score.value)?.minus(1)*/
        _score.value = (score.value)?.minus(1)
        nextWord()
    }
    fun onCorrect() {
        /*score.value = (score.value)?.plus(1)*/
        _score.value = (score.value)?.plus(1)
        nextWord()
    }


    /*private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word.value = wordList.removeAt(0)
        }*/
   /* private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }
    }*/

    private fun nextWord() {
        if (wordList.isEmpty()) {
            onGameFinish()
        } else {
            //Select and remove a _word from the list
            _word.value = wordList.removeAt(0)
        }
    }

    fun onGameFinish() {
        _eventGameFinish.value = true
    }


    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }
}
# SudokuApplication
## CSCI 4211 : Mobile Computing and Programming Project
### Team: Debussy Devs
### Members:
* Justing Luong
* James Nguyen
* Carlos Valdez


4/15/2022 --- Sudoku Updates<br>
<ul>
<li>activity_main.xml & MainActivity.java:</li>
    <ul>
        <li>Changed to ConstraintLayout</li>
        <li>Added ImageView</li>
        <li>The ImageView will contain the @drawable src as a logo for our application (sample image in-place)</li>
        <li>Added Button "Play" (functional)</li>
        <li>Should take to a new activity to select the difficulty</li>
        <ul>
            <li>Easy, Medium, Hard</li>
        </ul>
        <li>Added Button "Exit" (functional)</li>
        <ul>
            <li>Exits the application entirely</li>
        </ul>
    </ul>
</ul>
<ul>
<li>activity_select_difficulty.xml & SelectDifficultyActivity.java:</li>
    <ul>
        <li>Changed to ConstrantLayout</li>
        <li>Added ImageView</li>
            <li>The ImageView will contain the @drawable src as a logo for our application (sample image in-place)</li>
        <li>Added Button "Easy"</li>
        <li>Added Button "Medium"</li>
        <li>Added Button "Hard"</li>
    </ul>
</ul>

4/18/2022 & 4/19/2022--- Sudoku Updates<br>
<ul>
<li>Completed difficulty selection</li>
    <ul>
        <li>Changed to ConstraintLayout</li>
        <li>User's button click is stored in a varible, .putExtra is used to send this variable for usage</li>
        <li>easy = 1, medium = 2, hard = 3</li>
    </ul>
</ul>
<ul>
<li>Added activity_play_game.xml & PlayGameActivity.java</li>
    <ul>
        <li>RelativeLayout's (Nested)</li>
        <li>Inner RelativeLayout</li>
            <li>Contains top panel and holds Chronometer and ClockImage</li>
        <li>Outer RelativeLayout</li>
        <li>corresponds to custom board using Canvas, drawn grid with correct sizing, adjustable depending on the device chosen</li>
        <li>onClickEvent per square block (IN-PROGRESS)</li>
    </ul>
</ul>
  

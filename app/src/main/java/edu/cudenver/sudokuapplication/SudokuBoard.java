//package edu.cudenver.sudokuapplication;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//import android.view.View;
//
//import androidx.annotation.Nullable;
//
//public class SudokuBoard extends View {
//    private final int boardColor;
//    private final Paint boardColorPaint = new Paint();
//    private int cellSize;
//
//    public SudokuBoard(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//
//        // storing all attributes defined for our SudokuBoard
//        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
//                R.styleable.SudokuBoard, 0, 0);
//
//        // need to extract the individual attributes for our board and put them in individual variables
//        try {
//            // extracting attributes from our TypedArray
//            // and setting it = to our defined variables
//            boardColor = a.getInteger(R.styleable.SudokuBoard_boardColor, 0);
//        } finally {
//            // to free up memory for our application
//            a.recycle();
//        }
//    }
//
//    @Override
//    // for different devices being used
//    protected void onMeasure(int width, int height) {
//        super.onMeasure(width, height);
//
//        // Sudoku should be a perfect square, we need to determine that based on dimensions of the screen!
//        int dimension = Math.min(this.getMeasuredWidth(), this.getMeasuredHeight());
//        cellSize = dimension / 9;   // b/c 9x9 grid
//
//
//        // defining width and height of our view
//        setMeasuredDimension(dimension, dimension);
//    }
//
//    @Override
//    // the total area the view occupies on the user's screen in the view
//    protected void onDraw(Canvas canvas) {
//        // paint brush
//        boardColorPaint.setStyle(Paint.Style.STROKE);
//        boardColorPaint.setStrokeWidth(16);
//        // paint bucket
//        boardColorPaint.setColor(boardColor);
//
//        boardColorPaint.setAntiAlias(true);
//
//        canvas.drawRect(0, 0, getWidth(), getHeight(), boardColorPaint);
//        drawBoard(canvas);
//    }
//    private void drawThickLines() {
//        boardColorPaint.setStyle(Paint.Style.STROKE);
//        boardColorPaint.setStrokeWidth(10);
//        boardColorPaint.setColor(boardColor);
//    }
//
//    private void drawThinLines() {
//        boardColorPaint.setStyle(Paint.Style.STROKE);
//        boardColorPaint.setStrokeWidth(5);
//        boardColorPaint.setColor(boardColor);
//    }
//
//    private void drawBoard(Canvas canvas) {
//        //draw the rows and columns, every 3 we get a thick line in vertically and horizontally
//        for (int col = 0; col < 10; col++) {
//            if(col % 3 == 0){
//                drawThickLines();
//            } else {
//                drawThinLines();
//            }
//            // draw onto our view from the cell positioning at appropriate x, y coords
//            canvas.drawLine(cellSize * col, 0,
//                    cellSize * col, getWidth(), boardColorPaint);
//        }
//        for (int row = 0; row < 10; row++) {
//            if(row % 3 == 0){
//                drawThickLines();
//            } else {
//                drawThinLines();
//            }
//            // draw onto our view from the cell positioning at appropriate x, y coords
//            canvas.drawLine(0, cellSize * row,
//                    getWidth(), cellSize * row, boardColorPaint);
//        }
//    }
//}

//
//

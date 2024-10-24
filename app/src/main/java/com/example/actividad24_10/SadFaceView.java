package com.example.actividad24_10;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SadFaceView extends View {

    private Paint paint;

    public SadFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SadFaceView(Context context) {
        super(context);
        init();
    }

    private void init() {
        // Configurar la pintura para dibujar
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(8f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Dibujar la carita triste
        int width = getWidth();
        int height = getHeight();

        // Coordenadas del círculo de la cara
        float cx = width / 2;
        float cy = height / 2;
        float radius = Math.min(cx, cy) - 50;

        // Dibujar la cara (círculo grande)
        canvas.drawCircle(cx, cy, radius, paint);

        // Dibujar los ojos (círculos pequeños)
        float eyeRadius = radius / 8;
        float eyeOffsetX = radius / 4;
        float eyeOffsetY = radius / 3;

        // Ojo izquierdo
        canvas.drawCircle(cx - eyeOffsetX, cy - eyeOffsetY, eyeRadius, paint);

        // Ojo derecho
        canvas.drawCircle(cx + eyeOffsetX, cy - eyeOffsetY, eyeRadius, paint);

        // Dibujar la boca triste (un arco)
        float mouthRadius = radius / 2;
        float mouthStartX = cx - mouthRadius;
        float mouthEndX = cx + mouthRadius;
        float mouthY = cy + eyeOffsetY;

        // Dibujar el arco invertido para la boca triste
        canvas.drawArc(mouthStartX, mouthY, mouthEndX, mouthY + mouthRadius, 180, 180, false, paint);
    }
}


import cv2
import datetime
cap = cv2.VideoCapture(0);
fourcc= cv2.VideoWriter_fourcc(*'XVID')
out = cv2.VideoWriter('output.avi',fourcc,144.0,(640,480))
print(cap.isOpened())
print( cap.get(3) )
print( cap.get(4) )
cap.set(3,3000)
cap.set(4,3000)
print( cap.get(3) )
print( cap.get(4) )
while(cap.isOpened()):
    ret, frame = cap.read()
    if ret == True:
        font = cv2.FONT_ITALIC
        datet = str(datetime.datetime.now())
        text = 'Width: ' + str(cap.get(3)) + ' Height: ' + str(cap.get(4)) + ' Time: ' + datet
        frame = cv2.putText(frame, text, (10,50), font, 1, (0,255,255), 2, cv2.LINE_AA)

        cv2.imshow('frame', frame)

        if cv2.waitKey(1) & 0xFF == ord('q'):
            break
    else:
        break


cap.release()
out.release()
cv2.destroyAllWindows()
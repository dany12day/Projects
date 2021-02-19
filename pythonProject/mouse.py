import cv2
import numpy as np

#events = [i for i in dir(cv2) if 'EVENT' in i]
#print(events)

def click_event(event, x, y, flags, param):
    #culoare punct
    if event == cv2.EVENT_LBUTTONDOWN:
        blue  = img[y, x, 0]
        green = img[y, x, 1]
        red   = img[y, x, 2]
        cv2.circle(img, (x,y), 3, (0,0,255), -1)
        myColorImage = np.zeros((512,512,3), np.uint8)
        myColorImage[:]= [blue,green,red]
        cv2.imshow('color', myColorImage)

    #perechi de linii
    #if event == cv2.EVENT_LBUTTONDOWN:
    #    cv2.circle(img, (x, y), 10, (0,0,0), -1)
    #    points.append((x,y))
    #    if len(points) % 2 == 0:
    #        cv2.line(img, points[-1], points[-2], (0,0,0), 5)
    #    cv2.imshow('image',img)

    # cod culoare
    #if event == cv2.EVENT_RBUTTONDOWN:
    #    blue  = img[y, x, 0]
    #    green = img[y, x, 1]
    #    red   = img[y, x, 2]
    #    font = cv2.FONT_ITALIC
    #    strBGR = str(blue) + ', ' + str(green) + ', ' + str(red)
    #    cv2.putText(img, strBGR, (x, y), font, .5, (0, 0, 255), 2)
    #    cv2.imshow('image', img)

#img = np.zeros((512,512,3), np.uint8)
img = cv2.imread('lena.jpg')
cv2.imshow('image', img)

points = []

cv2.setMouseCallback('image', click_event)

cv2.waitKey(0)
cv2.destroyAllWindows()
import numpy as np
import cv2

#img = cv2.imread('lena.jpg',1)
img = np.zeros([512,512,3], np.uint8)
img = cv2.line(img, (0,0), (255,255),(255, 0 , 0), 6)
img = cv2.arrowedLine(img, (510,0), (255,255),(255, 255 , 0), 6)
img = cv2.rectangle(img, (203,203), (303,303), (0,0,0),10)

img = cv2.circle(img, (255,255), 50, (255,255,255), 1)
font = cv2.FONT_ITALIC
img = cv2.putText(img, 'OpenCV', (10,500), font,2,(123,321,234),4)
print(img)

cv2.imshow('image', img)

k = cv2.waitKey(0) & 0xFF

if k == ord('s'):
    cv2.imwrite('lena_copy.png', img)

cv2.destroyAllWindows()
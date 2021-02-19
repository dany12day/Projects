import numpy as np
import  cv2

img = cv2.imread('lena.jpg')
img2 = cv2.imread('lena_copy.png')

print(img.shape)
print(img.size)
print(img.dtype)
b,g,r = cv2.split(img)
img = cv2.merge((b,g,r))

ball = img[280:340, 330:390]

img[273:333, 100:160] = (0,100,0)
img2[273:333, 100:160] = (0,155,0)

dst = cv2.add(img, img2)

cv2.imshow('image', dst)
cv2.waitKey(0)
cv2.destroyAllWindows()
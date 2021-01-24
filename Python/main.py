import cv2
import numpy as np

image = cv2.imread('characters.jpeg', cv2.IMREAD_COLOR)
image = cv2.resize(image, None, fx=0.2, fy=0.2, interpolation=cv2.INTER_AREA)

image_gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
ret, thresh = cv2.threshold(image_gray, 80, 255, 0)

contours, _ = cv2.findContours(thresh, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
image = cv2.drawContours(image, contours, -1, (0, 0, 255), 2)

contour = contours[44]
epsilon = 0.001 * cv2.arcLength(contour, True)
approx = cv2.approxPolyDP(contour, epsilon, True)
image = cv2.drawContours(image, [approx], -1, (255, 0, 0), 3)


area = cv2.contourArea(contour)
length = cv2.arcLength(contour, True)
M = cv2.moments(contour)

print(area, length, M)

cv2.imshow("Image", image)
cv2.waitKeyEx(0)
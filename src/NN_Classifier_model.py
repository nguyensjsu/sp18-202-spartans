
# coding: utf-8

# In[ ]:


import sys
import numpy
import pickle
from sklearn.neural_network import MLPClassifier

filename= 'NN_Classifier.sav'
NN_Classifier_model = pickle.load(open(filename, 'rb'))

input=numpy.fromstring(sys.argv[1], dtype=int,sep=" ")
probability = NN_Classifier_model.predict_proba(input.reshape(1,-1))[0]

print(' '.join(map(str, probability)))
print(numpy.argmax(probability))


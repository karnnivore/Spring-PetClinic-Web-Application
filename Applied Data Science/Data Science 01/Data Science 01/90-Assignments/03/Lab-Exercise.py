#!/usr/bin/env python
# coding: utf-8

# # Reza Dibaj

# In[1]:


import pandas as pd


# In[2]:


myDF=pd.read_csv('test.csv')


# In[3]:


myDF.head()


# In[4]:


myCols = ['ID', 'Range', 'Value', 'Machine Type', 'Zip code']


# In[5]:


myDF=pd.read_csv('test.csv', header=None, names=myCols)


# In[6]:


myDF.head()


# In[7]:


myDF=pd.read_csv('test.csv', header=None, names=myCols, skiprows=1)


# In[8]:


myDF.head()


# In[9]:


type(myDF)


# In[10]:


myDF['Value']


# In[11]:


myDF.Value


# In[12]:


myDF['Brand']=myDF['Machine Type'] + myDF['Zip code']


# In[13]:


myDF.head()


# In[14]:


myDF['Total']=myDF['Range'] * myDF['Value']


# In[15]:


myDF.head()


# In[16]:


myDF.head()


# In[17]:


myDF.describe()


# In[18]:


myDF.describe


# In[19]:


myDF.shape


# In[20]:


myDF.dtypes


# In[21]:


myDF.describe(include=['object'])


# In[22]:


myDF.rename(columns = {'ID':'My ID'})


# In[23]:


myDF.head()


# In[24]:


myDF.rename(columns = {'ID':'My ID'}, inplace=True)


# In[25]:


myDF.head()


# In[26]:


myDF.columns


# In[27]:


myNewCol=['id', 'range', 'value', 'machine type', 'zip code', 'brand', 'total']


# In[28]:


myDF.columns = myNewCol


# In[29]:


myDF.columns


# In[30]:


myDF.columns = myDF.columns.str.replace(' ','_')


# In[31]:


myDF.columns


# In[32]:


myDF.drop(['brand', 'total'], axis=1, inplace=True)


# In[33]:


myDF.head()


# In[34]:


myDF.drop([3, 5], axis=0, inplace=True)


# In[35]:


myDF.head()


# In[36]:


myDF.value.sort_values()


# In[37]:


myDF.sort_values('value')


# In[38]:


myDF.sort_values(['range','value'], ascending=[True, False])


# In[39]:


myDF[(myDF.range >= 250) & (myDF.range <= 350)].sort_values('range')


# In[40]:


myDF.loc[(myDF.range >= 250) & (myDF.range <= 350) & (myDF.machine_type=='H') , ['id','value', 'machine_type']]


# In[41]:


myDF[myDF['machine_type'].isin(['H','R','X'])]


# In[42]:


myDF.dtypes


# In[43]:


import numpy as np


# In[44]:


myDF.select_dtypes(include=[np.number])


# In[ ]:





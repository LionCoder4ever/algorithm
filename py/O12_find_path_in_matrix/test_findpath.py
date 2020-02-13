import unittest
from findpath import findPath

class TestFindPath(unittest.TestCase):

    def testInvalidInputNull(self):
        with self.assertRaises(ValueError):
            findPath('','abtgcfcsjdeh', 3, 4)

    def testValidInputFound(self):
        self.assertTrue(findPath('bfce','abtgcfcsjdeh', 3, 4))

    def testValidInputSingleMatrix(self):
        self.assertFalse(findPath('ab','abc', 1, 0))

if __name__ == '__main__':
    unittest.main()
package offer;
/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 * 
 * 深度遍历 设置 [][]visited
 *
 */
public class _array_hasPath {
	
	static boolean ans=false;
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
		char[][] ch=new char[rows][cols];
		int k=0;
	
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				ch[i][j]=matrix[k++];
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(str[0]==ch[i][j]) {
					int[][] visited=new int[rows][cols];
					findPath(0,ch,rows,cols,i,j,str,visited);
				}
				if(ans)return ans;
			}
		}
		
		return ans;
    }
	
	public static void findPath(int strIdx,char[][] ch, int rows, int cols,int curRow,int curCol, char[] str,int[][] visited) {

		
		if(str[strIdx]==ch[curRow][curCol]&&visited[curRow][curCol]!=1) {
			if(strIdx==str.length-1) {
				ans=true;return;		
			}else {
				visited[curRow][curCol]=1;
				//right
				if((curCol+1)<cols&&visited[curRow][curCol+1]!=1) {
					findPath(strIdx+1,ch,rows,cols,curRow,curCol+1,str,visited);
				}
				//down
				if((curRow+1)<rows&&visited[curRow+1][curCol]!=1) {
					findPath(strIdx+1,ch,rows,cols,curRow+1,curCol,str,visited);
				}
				//left
				if((curCol-1)>=0&&visited[curRow][curCol-1]!=1) {
					findPath(strIdx+1,ch,rows,cols,curRow,curCol-1,str,visited);
				}
				//up
				if((curRow-1)>=0&&visited[curRow-1][curCol]!=1) {
					findPath(strIdx+1,ch,rows,cols,curRow-1,curCol,str,visited);
				}
		}

		}else {
			return;
		}

	}

	public static void main(String[] args) {
//		ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS     SLHECCEIDEJFGGFIE true
		char[] ch="ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
		char[] str="SLHECCEIDEJFGGFIE".toCharArray();
		if(hasPath(ch, 5, 8,str)) {
			System.out.print("true");
		}
		

	}

}

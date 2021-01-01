### 解题思路
此处撰写解题思路

### 代码

```c
typedef enum {
    ONE,
    TWO,
    THREE,
    BUTT
} NumType;

typedef struct {
    int *key;
    UT_hash_handle hh;
} MapNode;

MapNode *g_head;

int cmp(int *a, int *b)
{
    return *a - *b;
}

static inline void MapAddNode(int keySize, int key[keySize])
{
    MapNode *find = NULL;
    HASH_FIND(hh, g_head, key, sizeof(int) * keySize, find);
    if (find != NULL) {
        return;
    }
    find = (MapNode *)malloc(sizeof(*find));
    find->key = (int *)malloc(sizeof(int) * keySize);
    memcpy(find->key, key, sizeof(int) * keySize);
    HASH_ADD_KEYPTR(hh, g_head, find->key, sizeof(int) * 3, find);
    return;
}
static inline void MapDel(int **ret, int *returnSize, int *retColSize)
{
    MapNode *del = NULL;
    MapNode *tmp = NULL;
    HASH_ITER(hh, g_head, del, tmp) {
        retColSize[*returnSize] = 3;
        ret[(*returnSize)++] = del->key;
        HASH_DEL(g_head, del);
        free(del);
    }
    return;
}
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int **threeSum(int *nums, int numsSize, int *returnSize, int **returnColumnSizes)
{
    g_head = NULL;
    *returnSize = 0;
    if (numsSize < 3) {
        return NULL;
    }
    
    qsort(nums, numsSize, sizeof(*nums), cmp);
    for (int i = 0; i < numsSize - 2; i++) {
        for (int j = i + 1; j < numsSize - 1; j++) {
            int key[BUTT] = {nums[i], nums[j], 0 - (nums[i] + nums[j])};
            if (key[THREE] < key[TWO]) { /* 剪枝 */
                continue;
            }
            /* 二分查找和为0的第三个数 */
            if (bsearch(&key[THREE], &nums[j + 1], numsSize - j - 1, sizeof(*nums), cmp) == NULL) {
                continue;
            }
            MapAddNode(BUTT, key);
        }
    }
    
    int **ret = (int **)malloc(sizeof(*ret) * HASH_COUNT(g_head));
    int *retColSize = (int *)malloc(sizeof(*returnColumnSizes) * HASH_COUNT(g_head));
    MapDel(ret, returnSize, retColSize);
    *returnColumnSizes = retColSize;
    return ret;
}
```
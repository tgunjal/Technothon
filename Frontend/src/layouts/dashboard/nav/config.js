// component
import SvgColor from '../../../components/svg-color';

// ----------------------------------------------------------------------

 const icon = (name) => <SvgColor src={`/assets/icons/navbar/${name}.svg`} sx={{ width: 1, height: 1 }} />;

const navConfig = [
  {
    title: 'dashboard',
    path: '/dashboard/app',
    icon: icon('ic_analytics'),
  },
  {
    title: 'patients',
    path: '/dashboard/patients',
    icon: icon('ic_user'),
  },
  // {
  //   title: 'product',
  //   path: '/dashboard/products',
  //   icon: icon('ic_cart'),
  // },
  // {
  //   title: 'blog',
  //   path: '/dashboard/blog',
  //   icon: icon('ic_blog'),
  // },
  {
    title: 'DICOM Viewer',
    path: '/dwvcomponent',
    icon: icon('ic_dicom'),
  },
  {
    title: 'Logout',
    path: '/login',
    icon: icon('ic_logout'),
  },
  // {
  //   title: 'Not found',
  //   path: '/404',
  //   icon: icon('ic_blog'),
  // },
];

export default navConfig;
